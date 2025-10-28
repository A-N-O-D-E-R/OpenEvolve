package bio.anode.ale.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.anode.tool.graph.Node;

import bio.anode.ale.core.usage.AbstractUsage;
import bio.anode.ale.core.usage.fluidic.AbstractFluidicUsage;
import bio.anode.ale.core.usage.fluidic.ChamberUsage;
import bio.anode.ale.core.usage.fluidic.Connection;
import bio.anode.ale.core.usage.fluidic.EvacuationUsage;
import bio.anode.ale.core.usage.fluidic.FluidicComponantUsage;
import bio.anode.ale.core.usage.fluidic.valve.ValveUsage;
import lombok.ToString;

@ToString
public class Circuit {

    public static final String CIRCUIT = "circuit";

	public static final String VISITED = "visited";

	public static final String REACHABLE_PATH = "reachable";

    private Set<ValveUsage> activations = new HashSet<ValveUsage>();

	private Node<FluidicComponantUsage> root;

	private double weight;

	private double tubeLength;

	private int numberOfChamber;

	private boolean computedMetrics = false ;

	private Circuit() {
	}

	public Circuit(ValveUsage root, boolean active) {
		this.root = new Node<FluidicComponantUsage>(root);
		this.root.setAttribute(REACHABLE_PATH, Boolean.FALSE);
		
		if (active)
			addActivation(root) ;
	}

	public Circuit(EvacuationUsage root) {
		this.root = new Node<FluidicComponantUsage>(root);
		this.root.setAttribute(REACHABLE_PATH, Boolean.TRUE);
	}

	public Circuit(FluidicComponantUsage root, List<Circuit> circuits) {
		this.root = new Node<FluidicComponantUsage>(root);

		boolean reachable = false;

		for (Circuit circuit : circuits) {
			this.root.addChild(circuit.getRoot());
			circuit.getRoot().setParent(this.root);

			activations.addAll(circuit.getActivations());
	
			if (Boolean.TRUE == circuit.getRoot().getAttribute(REACHABLE_PATH))
				reachable = true;
		}

		this.root.setAttribute(REACHABLE_PATH, Boolean.valueOf(reachable));
		computedMetrics = false ;
	}

	public void buildFinished() {
		updateCircuitAttribute(root);
	}

	private void computeMetrics() {		
		weight = 0;
		tubeLength = 0;
		numberOfChamber=0;
		computeMetrics(root) ;
		
		weight = Math.round(weight * 10) / 10d;		
		computedMetrics = true ;
	}
	
	private void computeMetrics(Node<FluidicComponantUsage> node) {
		weight += node.getContent().getCurrentVolume();
		numberOfChamber += (node.getContent() instanceof ChamberUsage)?1:0;
		for (int i = 0; i < node.getChildrenCount(); i++) {
			Node<FluidicComponantUsage> childNode = node.getChild(i);

			if (childNode.getAttribute(REACHABLE_PATH) == Boolean.TRUE) {
				for (Connection connection : ((AbstractFluidicUsage) node.getContent()).getConnections())
					if (connection.getTarget() == childNode.getContent()) {
						tubeLength += connection.getLength();
						weight += connection.getVolume();
					}

				computeMetrics(childNode);
			}
		}
	}

	private void updateCircuitAttribute(Node<FluidicComponantUsage> node) {
		node.setAttribute(CIRCUIT, this);
		for (int i = 0; i < node.getChildrenCount(); i++)
			updateCircuitAttribute(node.getChild(i));
	}

	public void setRoot(FluidicComponantUsage node) {
		Node<FluidicComponantUsage> newRoot = new Node<FluidicComponantUsage>(node);
		newRoot.setAttribute(REACHABLE_PATH, root.getAttribute(REACHABLE_PATH));
		root.setParent(newRoot);
		newRoot.addChild(root);
		root = newRoot;
	}

	public double getWeight() {
		if (!computedMetrics)
			computeMetrics() ;

		return weight;
	}

	public double getTubeLength() {
		if (!computedMetrics )
			computeMetrics() ;
		
		return tubeLength;
	}

	public Node<FluidicComponantUsage> getRoot() {
		return root;
	}

	public Set<ValveUsage> getActivations() {
		return activations;
	}

	public void checkValidity() {
		// TODO verifier les divergences
	}

	public void addActivation(ValveUsage usage) {
		activations.add(usage);
	}


	@Override
	@SuppressWarnings("unchecked")
	public Object clone() {
		Circuit clone = new Circuit();
		clone.activations = new HashSet<ValveUsage>(activations);
		clone.root = (Node<FluidicComponantUsage>) root.clone();

		return clone;
	}

    public int getChamberCount() {
		if (!computedMetrics)
			computeMetrics() ;
		return numberOfChamber;
    }

}


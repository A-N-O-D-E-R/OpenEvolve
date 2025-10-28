package bio.anode.ale.service.fluidic.circuit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import bio.anode.ale.core.Circuit;
import com.anode.tool.graph.Node;
import bio.anode.ale.core.component.fluidic.Intake;
import bio.anode.ale.core.component.fluidic.valve.NormallyOpenedValve;
import bio.anode.ale.core.component.fluidic.valve.SolenoidValve;
import bio.anode.ale.core.exception.IllegalTopologyException;
import bio.anode.ale.core.usage.fluidic.AbstractFluidicUsage;
import bio.anode.ale.core.usage.fluidic.Connection;
import bio.anode.ale.core.usage.fluidic.EvacuationUsage;
import bio.anode.ale.core.usage.fluidic.FluidicComponantUsage;
import bio.anode.ale.core.usage.fluidic.IntakeUsage;
import bio.anode.ale.core.usage.fluidic.valve.DiverterUsage;
import bio.anode.ale.core.usage.fluidic.valve.ValveUsage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FluidicCircuitService {

	public List<Circuit> discoverCircuitsFrom(AbstractFluidicUsage usage) throws IllegalTopologyException{
		return new FluidicCircuitService().discoverCircuits((AbstractFluidicUsage) usage.getConnections().get(0).getTarget(), new FluidicPathVisitor(usage.getConnections().get(0)));
	}
    
    public Circuit getCircuit(AbstractFluidicUsage usage, FluidicPathVisitor followedPath) throws IllegalTopologyException {
        if(usage instanceof ValveUsage valveUsage ){
            return getCircuitValveStrategy(valveUsage,followedPath);
        }else if(usage instanceof EvacuationUsage evacuationUsage){
			return getCircuitEvacuationStrategy(evacuationUsage, followedPath);
		}else if(usage instanceof DiverterUsage diverterUsage){
			return getCircuitDiverterStartegy(diverterUsage,followedPath);
		}else{
			return getCircuitDefaultStrategy(usage,followedPath);
		}

    }

	private Circuit getCircuitEvacuationStrategy(EvacuationUsage usage, FluidicPathVisitor followedPath){
		followedPath.traceCurrentPosition();
		return new Circuit(usage) ;
	}

    private Circuit getCircuitValveStrategy(ValveUsage usage,FluidicPathVisitor followedPath) throws IllegalTopologyException {
        if (!((SolenoidValve)usage.getComponent()).isOpen(usage.isActive())) {
			followedPath.traceCurrentPosition();
			return new Circuit(usage, usage.isActive());
		}
        return getCircuitDefaultStrategy(usage,followedPath);
    }


	private Circuit getCircuitDiverterStartegy(DiverterUsage usage, FluidicPathVisitor followedPath) throws IllegalTopologyException {
		followedPath.traceCurrentPosition();
		Connection childConnection = usage.getNextConnection(followedPath.getCurrentPosition().getTargetConnector());
		if (childConnection==null) {
			return new Circuit(usage, usage.isActive());
		}

		try {
			followedPath.forward(childConnection);
			Circuit circuit = getCircuit(((AbstractFluidicUsage) childConnection.getTarget()),followedPath);
			if (usage.isActive()) {
				circuit.addActivation(usage) ;
			}

			circuit.setRoot(usage) ;

			return circuit ;
		} finally {
			followedPath.backward();
		}
	}

    private Circuit getCircuitDefaultStrategy(AbstractFluidicUsage usage, FluidicPathVisitor followedPath) throws IllegalTopologyException {
        followedPath.traceCurrentPosition();
		Connection lastConnectionFollowed = followedPath.getCurrentPosition() ;
		Circuit circuit = null;
		for (Connection connection : usage.getConnections()) {
			log.debug(connection.getTarget().getName()+"!="+lastConnectionFollowed.getRoot().getName());
			if (connection.getTarget() != lastConnectionFollowed.getTarget()) {
				followedPath.forward(connection);
				try{
					usage.getCircuits().add(circuit = getCircuit(((AbstractFluidicUsage) connection.getTarget()),followedPath));
				}finally{
					followedPath.backward();
				}
			}
		}

		if (usage.getCircuits().size() == 1) {
			circuit.setRoot(usage);
			usage.getCircuits().clear() ;
		}else {
			circuit = new Circuit(usage, usage.getCircuits());
			usage.setCircuits(new ArrayList<>(3));
		}
		return circuit;
    }



	public List<Circuit> discoverCircuits(AbstractFluidicUsage usage, FluidicPathVisitor followedPath) throws IllegalTopologyException {
		if(usage instanceof EvacuationUsage evacuationUsage){
			List<Circuit> circuits = new LinkedList<>();
			circuits.add(new Circuit(evacuationUsage)) ;
			return circuits ;
		}
		followedPath.traceCurrentPosition();

		List<Circuit> circuits = new LinkedList<>();

		Connection lastConnectionFollowed = followedPath.getCurrentPosition() ;

		for (Connection connection : usage.getConnections()) {
			if (connection.getTarget() != lastConnectionFollowed.getRoot()) {
				try {
					followedPath.forward(connection);
					for (Circuit circuit : discoverCircuits(((AbstractFluidicUsage) connection.getTarget()),followedPath)) {
						circuit.setRoot(usage);
						try {
							followedPath.backward() ;
							completeClosure(usage,lastConnectionFollowed, circuit, followedPath);
							circuits.add(circuit);
						} catch (IllegalTopologyException e) {
							log.debug("Illegal topology :",e.getMessage());
						}finally{
							followedPath.forward(connection);
						}
					}
					followedPath.backward() ;
				} catch (IllegalTopologyException e) {
					log.debug("Illegal topology :",e.getMessage());
				}
			}
		}
		return circuits;
	}


	private void completeClosure(AbstractFluidicUsage usage, Connection parentConnection, Circuit circuit, FluidicPathVisitor followedPath) throws IllegalTopologyException {
		FluidicComponantUsage childInCircuit = circuit.getRoot().getChild(0).getContent();

		for (Connection connection : ((AbstractFluidicUsage) circuit.getRoot().getContent()).getConnections()) {
			if (connection.getTarget() != parentConnection.getRoot() && connection.getTarget() != childInCircuit) {
				followedPath.forward(connection);

				try{
					completeClosure(((AbstractFluidicUsage) connection.getTarget()), circuit.getRoot(), circuit, followedPath);
				}finally{
					followedPath.backward();
				}
			}
		}
	}

	public void completeClosure(AbstractFluidicUsage usage,Node<FluidicComponantUsage> parent, Circuit circuit, FluidicPathVisitor followedPath) throws IllegalTopologyException {
		if(usage instanceof EvacuationUsage){
			throw new IllegalTopologyException("Impossible closure to evacuation "+usage.getName()+" "+usage.getId()) ;
		} else if(usage instanceof IntakeUsage intakeUsage && ((Intake)intakeUsage.getComponent()).getType() != Intake.Type.AIR) {
			throw new IllegalTopologyException("Impossible closure on intak " + usage.getName() + " " + usage.getId());
		}else if(usage instanceof ValveUsage valveUsage){
			completeClosureValveStrategy(valveUsage,parent,circuit,followedPath);
		}else if(usage instanceof DiverterUsage diverterUsage){
			completeClosureDiverterStrategy(diverterUsage, parent, circuit, followedPath);
		}else{
			completeClosureDefaultStategy(usage,parent,circuit,followedPath);
		}
	}

	private void completeClosureDiverterStrategy(DiverterUsage usage, Node<FluidicComponantUsage> parent,
			Circuit circuit, FluidicPathVisitor followedPath) {
		
				Connection nextConnection = usage.getNextConnection(followedPath.getCurrentPosition().getTargetConnector()) ;

				if (nextConnection!=null) {
					try {
						Node<FluidicComponantUsage> childNode = new Node<>(usage, parent);
						childNode.setAttribute(Circuit.REACHABLE_PATH, Boolean.FALSE);
						followedPath.forward(nextConnection);
						try{
							completeClosure(((AbstractFluidicUsage) nextConnection.getTarget()),childNode, circuit, followedPath);
						}finally{
							followedPath.backward();
						}
		
					} catch (IllegalTopologyException e) {
						parent.getChild(0).removeChildren();
						if(!usage.isActive()) {
							circuit.addActivation(usage);
						}
					}
				} else {
					Node<FluidicComponantUsage> childNode = new Node<>(usage, parent);
					childNode.setAttribute(Circuit.REACHABLE_PATH, Boolean.FALSE);
				}
	}

	private void completeClosureDefaultStategy(AbstractFluidicUsage usage,Node<FluidicComponantUsage> parent, Circuit circuit, FluidicPathVisitor followedPath) throws IllegalTopologyException {
		Node<FluidicComponantUsage> childNode = new Node<>(usage, parent);
		childNode.setAttribute(Circuit.REACHABLE_PATH, Boolean.FALSE);
		for (Connection connection : usage.getConnections()) {
			if (connection.getTarget() != parent.getContent()) {
				followedPath.forward(connection);
				try{
					completeClosure(((AbstractFluidicUsage) connection.getTarget()),childNode, circuit, followedPath);
				}finally{
					followedPath.backward();
				}
			}
		}
	}

	private void completeClosureValveStrategy(ValveUsage usage,Node<FluidicComponantUsage> parent, Circuit circuit, FluidicPathVisitor followedPath) throws IllegalTopologyException {
		if ((SolenoidValve)usage.getComponent() instanceof NormallyOpenedValve) {
			try {
				completeClosureDefaultStategy(usage,parent, circuit, followedPath);
			} catch (IllegalTopologyException e) {
				parent.getChild(0).removeChildren();
				circuit.addActivation(usage);
			}
		} else {
			Node<FluidicComponantUsage> childNode = new Node<>(usage, parent);
			childNode.setAttribute(Circuit.REACHABLE_PATH, Boolean.FALSE);
		}
	}
}


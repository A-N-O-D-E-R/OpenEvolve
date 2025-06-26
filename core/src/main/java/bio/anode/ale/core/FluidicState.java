package bio.anode.ale.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bio.anode.ale.core.component.fluidic.Intake;
import bio.anode.ale.core.usage.fluidic.FluidicComponantUsage;
import bio.anode.ale.core.usage.fluidic.IntakeUsage;
import com.anode.tool.graph.Node;

public class FluidicState {
    private List<Node<FluidicComponantUsage>> nodes;

	private transient Set<IntakeUsage> sources;

	public FluidicState(List<Node<FluidicComponantUsage>> nodes) {
		if (nodes == null)
			nodes = Collections.emptyList();

		this.nodes = nodes;
	}

	public List<Node<FluidicComponantUsage>> getNodes() {
		return nodes;
	}
	public Set<IntakeUsage> getIntakes() {
		if (sources == null)
			buildSources();
		return sources;
	}

	private void buildSources() {
		if (nodes.size() == 0)
			sources = Collections.emptySet();
		else {
			sources = new HashSet<IntakeUsage>();
			for (Node<FluidicComponantUsage> node : nodes)
				sources.add((IntakeUsage) ((Circuit) node.getAttribute(Circuit.CIRCUIT)).getRoot().getContent());
		}
	}

	public boolean containsAirOnly() {
		for (IntakeUsage intakeUsage : getIntakes()){
            Intake intake = ((Intake)intakeUsage.getComponent());
			if (intake.getType() != Intake.Type.AIR && intake.getType() != Intake.Type.HIGH_FLOW_AIR)
				return false;
        }
		return true;
	}
}

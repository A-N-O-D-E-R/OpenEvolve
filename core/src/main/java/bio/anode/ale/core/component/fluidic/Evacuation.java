package bio.anode.ale.core.component.fluidic;

import java.util.UUID;

import com.anode.tool.graph.Node;
import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Evacuation extends Component implements FluidicComponant{

    public Evacuation(UUID id, Model model, String serialNumber, int version) {
		super(id, model, serialNumber, version);
	}

	@Override
	public int getConnectorCount() {
		// abitrary number
		return 1;
	}

	@Override
	public double getVolume() {
		return 0;
	}

    protected Node<FluidicComponant> getCircuit(Node<FluidicComponant> parent) {
		return new Node<>(this, parent) ;
	}
}

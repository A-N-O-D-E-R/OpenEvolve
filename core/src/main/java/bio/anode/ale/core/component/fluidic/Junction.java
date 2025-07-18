package bio.anode.ale.core.component.fluidic;

import java.util.UUID;

import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Junction extends Component implements FluidicComponant {
    public Junction(UUID id, Model model, String serialNumber, int version) {
		super(id, model, serialNumber, version);
	}

	@Override
	public int getConnectorCount() {
		return 3;
	}

	@Override
	public double getVolume() {
		return 1;
	}
}

package bio.anode.ale.core.component.fluidic.valve;

import java.util.UUID;

import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.component.fluidic.FluidicComponant;
import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class SolenoidValve extends Component implements FluidicComponant{

    public SolenoidValve(UUID id, Model model, String serialNumber, int version) {
		super(id, model, serialNumber, version);
	}

	@Override
	public int getConnectorCount() {
		return 2 ;
	}

	@Override
	public double getVolume() {
		return 1 ;
	}

    public abstract boolean isOpen(boolean active) ;
}

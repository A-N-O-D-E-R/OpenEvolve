package bio.anode.ale.core.component.fluidic;

import java.util.UUID;

import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Chamber extends Component implements FluidicComponant {
	private double volume;

    public Chamber(UUID id, Model model, String serialNumber,int version,double volume) {
		super(id, model, serialNumber,version);
		this.volume =volume;
	}

    @Override
	public int getConnectorCount() {
		return 4 ;
	}

    @Override
	public double getVolume() {
		return volume ;
	}
}

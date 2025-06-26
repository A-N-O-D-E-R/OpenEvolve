package bio.anode.ale.core.component.fluidic;

import java.util.UUID;

import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Intake extends Component implements FluidicComponant{

	public Intake(UUID id, Model model, String serialNumber, int version,Type type) {
		super(id, model, serialNumber, version);
		this.type=type;
	}

	private Type type;

    @Override
	public int getConnectorCount() {
		return 1;
	}
	@Override
	public double getVolume() {
		return 0;
	}

    public enum Type {
		WATER("W", "H2O"),
        SODA("S", "NaOH"),
        MEDIUM("M", null),
        OXYDANT("O", "C2H6O5"),
        MEDIUM_COMPOUND("C", null),
        AIR("A", "Air"), 
        HIGH_FLOW_AIR("H", "Air");
		private String label;
		private String shortName;
        Type(String shortName, String label) {
			this.shortName = shortName;
			this.label = label;
		}
    }
}

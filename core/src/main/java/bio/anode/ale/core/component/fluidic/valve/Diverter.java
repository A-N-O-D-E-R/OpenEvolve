package bio.anode.ale.core.component.fluidic.valve;

import java.util.UUID;

import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Diverter extends SolenoidValve {
    public Diverter(UUID id, Model model, String serialNumber, int version) {
		super(id, model, serialNumber, version);
	}
	@Override
	public int getConnectorCount() {
		return 3;
	}
	@Override
	public boolean isOpen(boolean active) {
		return true;
	}
}

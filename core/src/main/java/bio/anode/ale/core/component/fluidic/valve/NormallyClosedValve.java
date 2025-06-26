package bio.anode.ale.core.component.fluidic.valve;

import java.util.UUID;

import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class NormallyClosedValve extends SolenoidValve {
    
    public NormallyClosedValve(UUID id, Model model, String serialNumber, int version) {
		super(id, model, serialNumber, version);
		//TODO Auto-generated constructor stub
	}

	@Override
	public boolean isOpen(boolean active) {
		return active;
	}
}

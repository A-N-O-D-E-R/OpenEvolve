package bio.anode.ale.core.usage.fluidic.valve;

import java.awt.Point;
import java.util.UUID;

import bio.anode.ale.core.component.fluidic.valve.SolenoidValve;
import bio.anode.ale.core.usage.fluidic.AbstractFluidicUsage;
import lombok.Getter;

@Getter
public class ValveUsage extends AbstractFluidicUsage {
    private String adress;
	private transient boolean active;

    public ValveUsage(UUID id, SolenoidValve valve, String name, String adress, boolean active, Point location) {
		super(id, valve, name,location);
		this.adress=adress;
		this.active=active;
	}
}

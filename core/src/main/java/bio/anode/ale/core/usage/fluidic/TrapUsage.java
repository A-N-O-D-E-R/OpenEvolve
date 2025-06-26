package bio.anode.ale.core.usage.fluidic;

import java.awt.Point;
import java.util.UUID;

import bio.anode.ale.core.component.fluidic.Trap;

public class TrapUsage  extends AbstractFluidicUsage  {

    public TrapUsage(UUID id, Trap trap, String name, Point location) {
        super(id, trap, name,location);
    }
    
}

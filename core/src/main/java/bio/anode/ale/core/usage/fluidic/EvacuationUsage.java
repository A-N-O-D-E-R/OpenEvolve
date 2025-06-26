package bio.anode.ale.core.usage.fluidic;

import java.awt.Point;
import java.util.UUID;
import bio.anode.ale.core.component.fluidic.Evacuation;

public class EvacuationUsage  extends AbstractFluidicUsage {

    public EvacuationUsage(UUID id, Evacuation componant, String name,Point location) {
        super(id, componant, name,location);
    }
    
}

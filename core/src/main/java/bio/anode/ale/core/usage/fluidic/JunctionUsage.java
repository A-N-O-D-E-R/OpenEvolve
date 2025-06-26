package bio.anode.ale.core.usage.fluidic;

import java.awt.Point;
import java.util.UUID;

import bio.anode.ale.core.component.fluidic.Junction;

public class JunctionUsage  extends CommonFluidicUsage {

    public JunctionUsage(UUID id, Junction junction, String name, Point location, Integer orientation) {
        super(id, junction, name,location,orientation);
    }
    
}

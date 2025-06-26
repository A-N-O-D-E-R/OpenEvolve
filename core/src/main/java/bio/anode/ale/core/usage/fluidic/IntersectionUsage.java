package bio.anode.ale.core.usage.fluidic;

import java.awt.Point;
import java.util.UUID;

import bio.anode.ale.core.component.fluidic.Intersection;

public class IntersectionUsage  extends CommonFluidicUsage {

    public IntersectionUsage(UUID id, Intersection intersection, String name, Point location, Integer orientation) {
        super(id, intersection, name, location,orientation);
    }
    
}

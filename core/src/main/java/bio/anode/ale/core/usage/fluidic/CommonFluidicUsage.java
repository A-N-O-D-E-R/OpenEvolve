package bio.anode.ale.core.usage.fluidic;

import java.awt.Point;
import java.util.UUID;

import bio.anode.ale.core.component.Component;

public class CommonFluidicUsage extends AbstractFluidicUsage{
    private Integer orientation ;

    public CommonFluidicUsage(UUID id, Component componant, String name, Point location, Integer orientation){
        super(id, componant, name, location);
        this.orientation=orientation;
    }
}

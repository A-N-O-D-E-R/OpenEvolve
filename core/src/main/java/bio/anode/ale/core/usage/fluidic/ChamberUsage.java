package bio.anode.ale.core.usage.fluidic;

import java.awt.Point;
import java.util.UUID;

import bio.anode.ale.core.component.fluidic.Chamber;

public class ChamberUsage extends CommonFluidicUsage {
	private double cultureVolume;
	private double wholeVolume;
    public ChamberUsage(UUID randomUUID,  Chamber chamber,String name, Point location, Integer orientation,double cultureVolume,double wholeVolume) {
        super(randomUUID, chamber, name, location, orientation);
        this.cultureVolume=cultureVolume;
        this.wholeVolume=wholeVolume;
    }
    
}

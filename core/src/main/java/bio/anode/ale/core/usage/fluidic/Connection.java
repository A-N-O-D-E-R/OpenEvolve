package bio.anode.ale.core.usage.fluidic;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*
 * A connection is  a representation of the fluidic tubing that link 2 fluidic component
 */
public class Connection implements Serializable {
	//TODO : definir des modeles de tuyau
	private static final double DIAMETRE_INTERNE_MM = 2 ;
	private FluidicComponantUsage root ;
	private int rootConnector ;
	private FluidicComponantUsage target ;
	private int targetConnector ;
	private String points ;
	// length in cm 
	private double length ;
	private int hashcode;

    public Connection(FluidicComponantUsage root, int rootConnector, FluidicComponantUsage target, int targetConnector) {
		super();
		this.root = root;
		this.rootConnector = rootConnector;
		this.target = target;
		this.targetConnector = targetConnector;
	}
	// Volume is assume a perfect cylinder -> π x r² x h 
	public double getVolume() {
		return (length*10*Math.PI*DIAMETRE_INTERNE_MM*DIAMETRE_INTERNE_MM)/1000 ;
	}

}
package bio.anode.ale.core.usage.fluidic;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Connection implements Serializable {
	//TODO : definir des modeles de tuyau
	private static final double DIAMETRE_INTERNE_MM = 2 ;
	private FluidicComponantUsage root ;
	private int rootConnector ;
	private FluidicComponantUsage target ;
	private int targetConnector ;
	private String points ;
	private double length ;
	private int hashcode;

    public Connection(FluidicComponantUsage root, int rootConnector, FluidicComponantUsage target, int targetConnector) {
		super();
		this.root = root;
		this.rootConnector = rootConnector;
		this.target = target;
		this.targetConnector = targetConnector;
	}
	public double getVolume() {
		return (length*10*Math.PI*DIAMETRE_INTERNE_MM*DIAMETRE_INTERNE_MM)/1000 ;
	}

}
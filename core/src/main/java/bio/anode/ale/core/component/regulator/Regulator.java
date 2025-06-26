package bio.anode.ale.core.component.regulator;

import java.util.UUID;

import bio.anode.ale.core.component.NetworkComponant;
import bio.anode.ale.core.specifications.Model;

public class Regulator extends NetworkComponant {
	
	private String unite;
	private Double minimum;
	private Double maximum;
	private boolean analog; 
	private Double correctionFactor;

    public Regulator(UUID id, Model model, String serialNumber, int version, String connectorClass,String unite,Double minimum,Double maximum,boolean analog,Double correctionFactor) {
		super(id, model, serialNumber, version, connectorClass);
		this.unite=unite;
		this.minimum=minimum;
		this.maximum=maximum;
		this.analog=analog;
		this.correctionFactor=correctionFactor;
	}

}

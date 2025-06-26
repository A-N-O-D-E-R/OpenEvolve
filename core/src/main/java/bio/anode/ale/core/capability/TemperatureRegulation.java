package bio.anode.ale.core.capability;

import java.io.Serializable;

import bio.anode.ale.core.component.regulator.Regulator;

public class TemperatureRegulation implements Serializable {
    private RegulationMode regulationMode;
	private Regulator regulator;
	private double targetValue;

    public enum RegulationMode {
		COOLING, 
		HEATING;
	}
}

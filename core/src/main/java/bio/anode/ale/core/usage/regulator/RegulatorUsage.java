package bio.anode.ale.core.usage.regulator;

import java.util.UUID;

import bio.anode.ale.core.component.regulator.Regulator;
import bio.anode.ale.core.usage.NetworkComponantUsage;
import bio.anode.ale.core.usage.sensor.SensorUsage;

public class RegulatorUsage extends NetworkComponantUsage {
    private SensorUsage sensorUsage;
    
    public RegulatorUsage(UUID id, Regulator regulator, String nom, String adresse, SensorUsage sensorUsage) {
		super(id, regulator, nom, adresse);
        this.sensorUsage=sensorUsage;
    }
}

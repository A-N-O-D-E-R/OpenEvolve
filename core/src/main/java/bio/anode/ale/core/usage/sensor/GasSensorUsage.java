package bio.anode.ale.core.usage.sensor;

import java.util.UUID;

import bio.anode.ale.core.component.sensor.GasSensor;

public class GasSensorUsage extends SensorUsage{
    public GasSensorUsage(UUID identifiant, GasSensor component, String nom, String adresse, long updateFrequency,
            double sensitivity, Double alert) {
        super(identifiant, component, nom, adresse, updateFrequency, sensitivity, alert);
    }
}
package bio.anode.ale.core.usage.sensor;

import java.util.UUID;

import bio.anode.ale.core.component.sensor.WeightSensor;

public class WeightSensorUsage extends SensorUsage {
    public WeightSensorUsage(UUID identifiant, WeightSensor composant, String nom, String adresse, long frequence, double sensibilite, Double alerte) {
		super(identifiant, composant, nom, adresse, frequence, sensibilite, alerte);
	}
}

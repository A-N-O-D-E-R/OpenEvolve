package bio.anode.ale.core.usage.sensor;

import java.util.UUID;

import bio.anode.ale.core.component.sensor.Thermometer;

public class ThermometerUsage extends SensorUsage {

    public ThermometerUsage(UUID identifiant, Thermometer composant, String nom, String adresse, long frequence, double sensibilite, Double alerte) {
		super(identifiant, composant, nom, adresse, frequence, sensibilite, alerte);
	}
}

package bio.anode.ale.core.usage.sensor;

import java.util.UUID;

import bio.anode.ale.core.component.sensor.PHmeter;

public class PHMeterUsage extends SensorUsage {
    public PHMeterUsage(UUID identifiant, PHmeter composant, String nom, String adresse, long frequence, double sensibilite, Double alerte) {
		super(identifiant, composant, nom, adresse,frequence,sensibilite,alerte);
	}
}

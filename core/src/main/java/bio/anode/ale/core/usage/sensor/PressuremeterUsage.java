package bio.anode.ale.core.usage.sensor;

import java.util.UUID;

import bio.anode.ale.core.component.sensor.Pressuremeter;

public class PressuremeterUsage extends SensorUsage {

    public PressuremeterUsage(UUID identifiant, Pressuremeter composant, String nom, String adresse, long frequence, double sensibilite, Double alerte) {
		super(identifiant, composant, nom, adresse,frequence,sensibilite,alerte);
	}
}

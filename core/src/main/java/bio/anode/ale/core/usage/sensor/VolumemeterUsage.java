package bio.anode.ale.core.usage.sensor;

import java.util.UUID;

import bio.anode.ale.core.component.sensor.VolumeMeter;

public class VolumemeterUsage extends SensorUsage {
    public VolumemeterUsage(UUID identifiant, VolumeMeter composant, String nom, String adresse, long frequence, double sensibilite, Double alerte) {
		super(identifiant, composant, nom, adresse, frequence, sensibilite, alerte);
	}
}
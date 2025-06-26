package bio.anode.ale.core.usage.sensor;

import java.util.UUID;

import bio.anode.ale.core.component.sensor.Turbidimeter;

public class TurbidimeterUsage extends SensorUsage {
    public TurbidimeterUsage(UUID identifiant, Turbidimeter composant, String nom, String adresse, long frequence, double sensibilite, Double alerte) {
		super(identifiant, composant, nom, adresse, frequence, sensibilite, alerte);
	}
}
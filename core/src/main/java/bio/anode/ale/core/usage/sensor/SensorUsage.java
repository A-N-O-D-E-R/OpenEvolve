package bio.anode.ale.core.usage.sensor;

import java.util.Date;
import java.util.UUID;

import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.usage.NetworkComponantUsage;
import lombok.Getter;
@Getter
public class SensorUsage extends NetworkComponantUsage {
    private long updateFrequency;
    private double sensitivity;
    private Double alert;
    private double measure;
    private Date lastMeasure;
    private Double errorDelta;
    private Boolean installed;

    public SensorUsage(UUID identifiant, Component component, String nom, String adresse, long updateFrequency, double sensitivity, Double alert) {
      super(identifiant, component, nom, adresse);
      this.updateFrequency = updateFrequency ;
      this.sensitivity = sensitivity ;
      this.alert = alert ;
    }

  public boolean thresholdExceeded() {
		return alert!=null && measure>=alert.doubleValue();
	}
}

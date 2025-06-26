package bio.anode.ale.core.usage.sensor;

import java.util.UUID;

import bio.anode.ale.core.component.sensor.Memorymeter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemorymeterUsage extends SensorUsage {
    private transient double maximum ;
    
    public MemorymeterUsage(UUID identifiant, Memorymeter component, String nom, String adresse, long updateFrequency,
            double sensitivity, Double alert) {
        super(identifiant, component, nom, adresse, updateFrequency, sensitivity, alert);
    }

    @Override
	public boolean thresholdExceeded() {
		return getAlert()!=null && (maximum-getMeasure())/maximum>=getAlert() ;
	}

}

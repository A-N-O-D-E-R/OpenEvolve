package bio.anode.ale.core.component.sensor;

import java.util.UUID;

import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class VolumeMeter extends Sensor{

    public VolumeMeter(UUID id, Model model, String serialNumber, int version, String connectorClass, String unit) {
        super(id, model, serialNumber, version, connectorClass, unit);
        //TODO Auto-generated constructor stub
    }
    
}

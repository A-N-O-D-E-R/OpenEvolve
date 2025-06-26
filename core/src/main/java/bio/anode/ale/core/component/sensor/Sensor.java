package bio.anode.ale.core.component.sensor;

import java.util.UUID;

import bio.anode.ale.core.component.NetworkComponant;
import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Sensor extends NetworkComponant{
    private String unit;
    public Sensor(UUID id, Model model, String serialNumber, int version, String connectorClass, String unit) {
        super(id, model, serialNumber, version, connectorClass);
        this.unit=unit;
    }
}

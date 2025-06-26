package bio.anode.ale.core.component.actuator;

import java.util.UUID;

import bio.anode.ale.core.component.NetworkComponant;
import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Actuator extends NetworkComponant {

    public Actuator(UUID id, Model model, String serialNumber, int version, String connectorClass) {
        super(id, model, serialNumber, version, connectorClass);
    }
    
}

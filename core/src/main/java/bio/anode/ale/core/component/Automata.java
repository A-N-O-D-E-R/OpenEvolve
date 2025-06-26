package bio.anode.ale.core.component;

import java.util.UUID;

import bio.anode.ale.core.component.actuator.Actuator;
import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Automata extends Actuator{

    public Automata(UUID id, Model model, String serialNumber, int version, String connectorClass) {
        super(id, model, serialNumber, version, connectorClass);
    }
    
}

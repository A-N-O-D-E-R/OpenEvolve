package bio.anode.ale.core.usage.actuator;

import java.util.UUID;

import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.usage.NetworkComponantUsage;

public class ActuatorUsage extends NetworkComponantUsage{

    public ActuatorUsage(UUID identifiant, Component component, String name, String adress) {
        super(identifiant, component, name, adress);
    }
    
}

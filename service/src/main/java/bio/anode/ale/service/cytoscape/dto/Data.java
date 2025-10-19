package bio.anode.ale.service.cytoscape.dto;

import bio.anode.ale.core.component.fluidic.FluidicComponant;
import bio.anode.ale.core.usage.fluidic.Connection;
import bio.anode.ale.core.usage.fluidic.FluidicComponantUsage;

public class Data {
    private String id;
    private String name;
    private String source;
    private String target;

    public Data(FluidicComponantUsage usage) {
        this.id=usage.getId().toString();
        this.name=usage.getName();
    }

    public Data(Connection connection) {
        this.source=connection.getRoot().getId().toString();
        this.target=connection.getTarget().getId().toString();
    }
    
}

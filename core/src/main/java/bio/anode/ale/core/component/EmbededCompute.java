package bio.anode.ale.core.component;

import java.util.UUID;

import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class EmbededCompute extends NetworkComponant{

    public EmbededCompute(UUID id, Model model, String serialNumber, int version, String connectorClass) {
        super(id, model, serialNumber, version, connectorClass);
        //TODO Auto-generated constructor stub
    }
    
}

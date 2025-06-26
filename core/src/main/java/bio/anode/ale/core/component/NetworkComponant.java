package bio.anode.ale.core.component;

import java.util.UUID;

import bio.anode.ale.core.specifications.Model;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public abstract class NetworkComponant extends Component {
    public NetworkComponant(UUID id, Model model, String serialNumber, int version, String connectorClass) {
        super(id, model, serialNumber, version);
        this.connectorClass=connectorClass;
    }

    protected String connectorClass;
}

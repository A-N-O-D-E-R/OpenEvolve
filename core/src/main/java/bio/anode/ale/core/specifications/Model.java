package bio.anode.ale.core.specifications;

import java.util.UUID;

import com.anode.tool.persistance.Persistable;
import bio.anode.ale.core.component.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Model implements Persistable {
    private UUID id;
    private String name;
    private String supplierReference;
    private Supplier supplier;
    private Class<? extends Component> componantClass;
    private String defaultConnector;
}

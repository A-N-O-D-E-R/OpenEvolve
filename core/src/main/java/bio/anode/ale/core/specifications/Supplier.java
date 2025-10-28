package bio.anode.ale.core.specifications;

import java.io.Serializable;
import java.util.UUID;

import com.anode.tool.persistance.Persistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Supplier implements Persistable {
    
    private Serializable id;
    private String name;

    public enum Type{
        INTERNAL,
        CONTRACTOR,
        SHOP
    }
}

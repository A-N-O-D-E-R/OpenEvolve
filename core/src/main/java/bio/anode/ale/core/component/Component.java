package bio.anode.ale.core.component;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.anode.tool.persistance.Persistable;

import bio.anode.ale.core.specifications.Model;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Component implements Serializable, Persistable {
    private UUID id;
    private Model model;
    private String serialNumber;
    private int version;

    public void addChildren(List<Persistable> childList) {
		childList.add(getModel()) ;
	}

}

package bio.anode.ale.core.usage;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.anode.tool.persistance.Persistable;

import bio.anode.ale.core.component.Component;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractUsage implements ComponentUsage {
    private Serializable id;
    private Component component ;
    private transient int version;
	private String name ;
	private int hashname;
    private int hashcomponant = 0;

    public AbstractUsage(UUID id, Component component, String name) {
		setId(id) ;
		setComponent(component) ;
		this.name = name;
	}

    @Override
    public void addChildren(List<Persistable> childList) {
        childList.add(getComponent()) ;
		getComponent().addChildren(childList) ;
    }
}

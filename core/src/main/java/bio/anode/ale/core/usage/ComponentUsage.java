package bio.anode.ale.core.usage;

import java.util.List;

import com.anode.tool.persistance.Persistable;
import bio.anode.ale.core.component.Component;

public interface ComponentUsage extends Persistable{
	public Component getComponent() ;
	public void setComponent(Component composant) ;
	public String getName() ;
	public void setName(String name) ;	
	public void addChildren(List<Persistable> childList) ;
}

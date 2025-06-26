package bio.anode.ale.core.usage;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.component.NetworkComponant;
import bio.anode.ale.core.exception.ConnectorInstanciationException;

import com.anode.tool.commands.compile.ClassPathUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NetworkComponantUsage extends AbstractUsage {
    private String adress;
	private boolean accessible;
	private transient Object connector;


    public NetworkComponantUsage(UUID identifiant, Component component, String name, String adress){
        super(identifiant,component,name);
        this.adress=adress;
    }
    public Object getConnector() throws ConnectorInstanciationException{
        if(Objects.nonNull(connector))
            return connector;
        String connectorClassname = ((NetworkComponant)getComponent()).getConnectorClass();
        try{
            List<Object> parameters = List.of(adress.split(";"));
            Class[] parameterTypes = new Class[parameters.size()];
            Arrays.fill(parameterTypes, String.class);
            parameterTypes[0] = this.getClass();
            return ClassPathUtils.instanciate(connectorClassname, this.getClass().getClassLoader() ,parameters.toArray(new Object[parameters.size()]),parameterTypes);
        } catch (InvocationTargetException e) {
            ConnectorInstanciationException ex = new ConnectorInstanciationException("While instanciating connector from " + connectorClassname + ";" + adress + " : "
                    + e.getTargetException());
            ex.setStackTrace(e.getTargetException().getStackTrace());
            throw ex;

        } catch (Exception e) {
            throw new ConnectorInstanciationException("While instanciating connector from " + connectorClassname + ";" + adress, e);
        }
    }
}

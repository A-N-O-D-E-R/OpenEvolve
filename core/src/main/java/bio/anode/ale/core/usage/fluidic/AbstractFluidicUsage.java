package bio.anode.ale.core.usage.fluidic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.anode.tool.graph.Node;

import bio.anode.ale.core.Circuit;
import bio.anode.ale.core.FluidicState;
import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.component.fluidic.FluidicComponant;
import bio.anode.ale.core.usage.AbstractUsage;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class AbstractFluidicUsage extends AbstractUsage implements FluidicComponantUsage{

    protected List<Connection> connections = new LinkedList<>();
    private Point location;
	private transient List<FluidicState> fluidicHistory = new LinkedList<>();
	private transient List<Circuit> circuits = new ArrayList<>(3) ;

	public AbstractFluidicUsage(UUID id, Component componant, String name,Point location){
		super(id, componant, name);
		this.location=location;
	}
    private void setConnection(Connection connection) {
		if (!connections.contains(connection)) {
			connections.add(connection);
		}
	}
    private void unsetConnection(int connector) {
		connections.remove(getConnection(connector));
	}

    @Override
	public boolean isCompletelyConnected() {
		return connections.size() == ((FluidicComponant) getComponent()).getConnectorCount();
	}


    @Override
    public void connect(int connector, FluidicComponantUsage target, int targetConnector) {
        Connection connection = getConnection(connector);
		Connection targetConnection = target.getConnection(targetConnector);
		if(connection !=null){
			if(connection.getTarget().equals(target) && targetConnector==connection.getTargetConnector())
				log.debug(this.getName()+" connector n°"+connector+" is already connect to "+target.getName()+" n°"+targetConnector);
			else
				log.debug(this.getName()+" ("+this.getId()+") connector n°"+connector+" cannot be used to connect to "+target.getName()+" ("+target.getId()+") n°"+targetConnector+", it is already used to connect "+connection.getTarget().getName()+" n°"+connection.getTargetConnector());
			
		}else if(targetConnection !=null){
			if(targetConnection.getTarget().equals(this) && connector==targetConnection.getTargetConnector())
				log.debug(target.getName()+" connector n°"+targetConnector+" is already connect to "+this.getName()+" n°"+connector);
			else
				log.debug(target.getName()+" ("+target.getId()+") connector n°"+targetConnector+" cannot be used to connect to "+this.getName()+" ("+this.getId()+") n°"+connector+", it  is already used to connect "+targetConnection.getTarget().getName()+" n°"+targetConnection.getTargetConnector());
		}else{
			this.setConnection(new Connection(this, connector, target, targetConnector));
			((AbstractFluidicUsage) target).setConnection(new Connection(target, targetConnector, this, connector));
		}
		 
	}
    
    @Override
    public void disconnect(int position) {
        Connection connection = getConnection(position);
		if (connection != null) {
			((AbstractFluidicUsage) connection.getTarget()).unsetConnection(connection.getTargetConnector());
			unsetConnection(position);
		}
    }


    @Override
    public Connection getConnection(int connector) {
        for (Connection connection : connections) {
			if (connection.getRootConnector() == connector) {
				return connection;
			}
		}
		return null;
    }



    @Override
	public FluidicState getCurrentFluidicState() {
		return fluidicHistory.size()==0? new FluidicState(null) : fluidicHistory.get(fluidicHistory.size()-1) ;
	}

	@Override
	public void addFluidicState(List<Node<FluidicComponantUsage>> nodes) {
		fluidicHistory.add(new FluidicState(nodes)) ;
	}


    @Override
	public void clearFluidicHistory() {
		fluidicHistory.clear() ;
	}


    @Override
    public double getCurrentVolume() {
        return getCurrentFluidicState().getNodes().size()==0?0:((FluidicComponant)getComponent()).getVolume() ;
    }
}

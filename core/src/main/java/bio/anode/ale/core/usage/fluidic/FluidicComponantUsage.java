package bio.anode.ale.core.usage.fluidic;

import java.util.List;

import bio.anode.ale.core.FluidicState;
import com.anode.tool.graph.Node;
import bio.anode.ale.core.usage.ComponentUsage;

public interface FluidicComponantUsage extends ComponentUsage {
	
	public boolean isCompletelyConnected() ;
	
	public void connect(int connecteur, FluidicComponantUsage target, int targetConnector) ;
	
	public void disconnect(int position) ;
	
	public Connection getConnection(int connecteur) ;
	
	public java.awt.Point getLocation() ;
	
	public void setLocation(java.awt.Point location) ;
	
	public FluidicState getCurrentFluidicState() ;
	
	public List<FluidicState> getFluidicHistory() ;
	
	public void clearFluidicHistory() ;
	
	public void addFluidicState(List<Node<FluidicComponantUsage>> nodes) ;
	
	public double getCurrentVolume();	
	
}


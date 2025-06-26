package bio.anode.ale.core.usage.fluidic.valve;

import java.awt.Point;
import java.util.UUID;

import bio.anode.ale.core.component.fluidic.valve.Diverter;
import bio.anode.ale.core.usage.fluidic.Connection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiverterUsage extends ValveUsage {

    private Integer defaultOutlet = 0;
    
    public DiverterUsage(UUID id, Diverter valve, String name, String adress, boolean active, Point location) {
        super(id, valve, name, adress,active,location);
    }
    

    public Connection getNextConnection(int comingFrom) {
		Integer connecteur ;
		switch(comingFrom) {
		// arrivee par le haut
		case 1 : connecteur = isActive()?oppositeOutlet():defaultOutlet ; break ;

		// arrivee par la gauche
		case 0 : connecteur = ((defaultOutlet==0 && !isActive()) || (defaultOutlet==2 && isActive()))?1:null ; break ;

		// arrivee par la droite
		case 2 : connecteur = ((defaultOutlet==0 && isActive()) || (defaultOutlet==2 && !isActive()))?1:null ;break ;
		default:
			throw new RuntimeException("Don't know how to handle connecteur "+comingFrom) ;
		}

		Connection childConnection = null ;
		if (connecteur!=null) {
			childConnection = getConnection(connecteur) ;
		}

		return childConnection;
	}


    private int oppositeOutlet() {
		return defaultOutlet==0?2:0 ;
	}

    public void setDefaultOutlet(Integer defaultOutlet) {
		assert defaultOutlet==0 || defaultOutlet==2 : "Invalid value for outlet : " + defaultOutlet ;
		this.defaultOutlet = defaultOutlet;
	}
}

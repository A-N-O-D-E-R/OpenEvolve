package bio.anode.ale.service;

import java.util.List;

import com.anode.tool.event.Event;
import com.anode.tool.event.Filter;
import com.anode.tool.service.CommonService;

public interface EventService extends CommonService{
    /**
     * @param filter un filtre optionnel
     * @return une liste non nulle d evenements tries par ordre croissant d'age
     *         lus dans la base
     */
    public List<? extends Event> getEvents(Filter filter);
    
	
    /**
     * @param filter un filtre optionnel
     * @return true si au moins un evenement a ete trouve
     */
    public boolean eventExists(Filter filter) ;

    /**
     * @return l'evt le plus recent enregistre pour cette adresse (eventuellement null)
     */
    public Event getMostRecentEvent(String epcAdress) ;
}

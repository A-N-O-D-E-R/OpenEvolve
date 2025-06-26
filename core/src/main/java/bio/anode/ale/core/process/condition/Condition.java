package bio.anode.ale.core.process.condition;

import java.io.Serializable;

import com.anode.tool.persistance.Persistable;

public interface Condition extends Serializable, Persistable{
    
    public boolean conditionRemplie();
    /**
     * Remet a zero la verification des conditions.
     * Utile pour les conditons a etat.
     * Appele quand la tache associee a ete executee.
     */
    public void restartConditionChecking();

    /**
     * @return un descriptif du resultat de la derniere evaluation de la condition
     */
    public String getLastCheckContexte();
}

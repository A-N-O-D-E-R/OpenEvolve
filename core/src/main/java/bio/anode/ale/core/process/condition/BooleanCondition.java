package bio.anode.ale.core.process.condition;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooleanCondition implements Condition {
    private Serializable id;
    private boolean fulfield  = true ;

    public boolean conditionRemplie() {
        return fulfield;
    }

    public String getLastCheckContexte() {
		return "";
	}


	public void restartConditionChecking() {
	}
}

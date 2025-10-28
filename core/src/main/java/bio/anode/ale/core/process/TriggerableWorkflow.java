package bio.anode.ale.core.process;

import java.io.Serializable;

import com.anode.tool.persistance.Persistable;
import lombok.Getter;
import lombok.Setter;

/*
 * This is a simple Workflow wrapper that will some information on the priority for futher scheduling
 */

@Getter
@Setter
public class TriggerableWorkflow implements Persistable{
    Serializable id;
    private Integer identifiant;
	private int version;
	private String nom;
	private int priorite;
	private boolean internal = false;
    private Operation definition;
}

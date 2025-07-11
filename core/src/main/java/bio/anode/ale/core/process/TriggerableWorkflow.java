package bio.anode.ale.core.process;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.UUID;

import com.anode.tool.persistance.Persistable;
import com.anode.workflow.entities.workflows.WorkflowDefinition;

import lombok.Getter;
import lombok.Setter;

/*
 * This is a simple Workflow wrapper that will some information on the priority for futher scheduling
 */

@Getter
@Setter
public class TriggerableWorkflow implements Persistable{
    UUID id;
    private Integer identifiant;
	private int version;
	private String nom;
	private int priorite;
	private boolean internal = false;
    private Operation definition;
}

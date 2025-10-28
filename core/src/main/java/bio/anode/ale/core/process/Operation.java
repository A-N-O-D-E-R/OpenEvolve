package bio.anode.ale.core.process;

import com.anode.workflow.entities.workflows.WorkflowDefinition;

/*
 * This is a spécial case of a workflow we need to add the expected duration to check if the operation is ok or not
 */
public abstract class Operation extends WorkflowDefinition{
	private int version;
	protected long durationInMillisec = 0;
}

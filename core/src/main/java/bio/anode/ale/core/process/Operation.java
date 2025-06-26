package bio.anode.ale.core.process;

import com.anode.workflow.entities.workflows.WorkflowDefinition;


public abstract class Operation extends WorkflowDefinition{
	private int version;
	protected long durationInMillisec = 0;
}

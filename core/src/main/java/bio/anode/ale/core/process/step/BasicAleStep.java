package bio.anode.ale.core.process.step;

import com.anode.workflow.entities.steps.InvokableRoute;


public abstract class BasicAleStep  implements InvokableRoute{
	private int version;
	private long duree = 0 ;
	private String description;
}

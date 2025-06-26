package bio.anode.ale.core.view;

import java.util.Date;

import com.anode.workflow.entities.steps.Step;

import bio.anode.ale.core.process.Operation;
import bio.anode.ale.core.process.TriggerableWorkflow;
import bio.anode.ale.core.process.trigger.Trigger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionContexteView implements Cloneable {

	// partie persistante
	private TriggerableWorkflow tache;

	private Trigger declencheur;

	private Operation operation;

	private Step etape;

	private Date debutEtape;

	private Date debutOperation;

	private Date demarrage;

	private Date arret;

	private Boolean inStepMode;

	private long tempsRestant;

	private long tempsRestantEtape;

	private boolean isValidationRequired;


	public ExecutionContexteView clone() {
		try {
			return (ExecutionContexteView) super.clone() ;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e) ;
		}
	}
}
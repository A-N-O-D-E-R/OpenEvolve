package bio.anode.ale.core.process.step;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import com.anode.workflow.entities.steps.responses.RouteResponse;

import bio.anode.ale.core.connector.ActuatorConnector;
import bio.anode.ale.core.usage.fluidic.valve.ValveUsage;
import lombok.Getter;

@Getter
public class FluidicStep extends BasicAleStep{
	public enum ActivationMode implements Serializable {
		TRANSIENT, PERSISTANT, CLEAR ;
	}
	private Set<ValveUsage> activations ;
	private ActivationMode activationMode;
	private ActuatorConnector valveConnector;

	public FluidicStep( Set<ValveUsage> activations){
		this.activations = activations;
		this.activationMode=ActivationMode.TRANSIENT;
	}
  

    public void addActivation(ValveUsage usage) {
		activations.add(usage) ;
	}

	public boolean isRepos() {
		return activations.size()==0 ;
	}

	public ActivationMode getActivationMode() {
		return activationMode == null ? ActivationMode.TRANSIENT : activationMode;
	}

    public boolean isActivated(ValveUsage vanneUsage) {
		UUID vanneId = vanneUsage.getId() ;

		for(ValveUsage activatedValve : getActivations()) {
			if (activatedValve.getId().equals(vanneId)) {
				return true ;
			}
		}

		return false ;
	}

    @Override
    public RouteResponse executeRoute() {
		//TODO : Handle valve activation
		activations.parallelStream().forEach(valve -> valve.getAdress());
		return null;
    }


}

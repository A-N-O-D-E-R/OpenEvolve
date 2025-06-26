package bio.anode.ale.core.culture;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.anode.tool.persistance.Persistable;

import bio.anode.ale.core.process.CultivationMode;
import bio.anode.ale.core.process.TriggerableWorkflow;
import bio.anode.ale.core.specifications.Experiment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Culture implements Persistable {
    private UUID id;
    private State state =State.IDLE;
    private int version;
	private String nom;

    private List<CultivationMode> availableCultivationModes = new LinkedList<>();
    private CultivationMode currentCultivationMode;
    private Experiment currentWorkingProject;

    private TriggerableWorkflow unactiveTriggerableWorkflow;

    private transient Double cultivationVolume = null;

    public boolean isActive() {
		return state.equals(State.CULTURE);
	}

	public void setActive(boolean active) {
		if (active)
			setState(State.CULTURE);
		else 
		    setState(State.IDLE);
	}
    
    public enum State {
		CULTURE("C", "Culture"), STEADY("S", "Steady"), IDLE("I", "Idle");

		private String label;

		private String shortName;

		State(String shortName, String label) {
			this.shortName = shortName;
			this.label = label;
		}

		public String getLabel() {
			return label;
		}

		public String getShortName() {
			return shortName;
		}
	}
}

package bio.anode.ale.core.event.operators;

import bio.anode.ale.core.event.Event;
import bio.anode.ale.core.usage.fluidic.IntakeUsage;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class ManualMeasureEvent extends OperatorEvent{
    private double measure;
	private double previousValue;
	private IntakeUsage intakeUsage;
	@Override
	public int compareTo(Event arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
	}
}

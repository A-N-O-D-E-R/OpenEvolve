package bio.anode.ale.core.usage.fluidic;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import bio.anode.ale.core.component.fluidic.Intake;
import bio.anode.ale.core.specifications.Media;
import bio.anode.ale.core.usage.fluidic.valve.ValveUsage;
import bio.anode.ale.core.usage.sensor.PressuremeterUsage;
import bio.anode.ale.core.usage.sensor.VolumemeterUsage;
import bio.anode.ale.core.usage.sensor.WeightSensorUsage;
import lombok.Getter;

@Getter
public class IntakeUsage extends AbstractFluidicUsage {
    
	private double debit = 0;

	private double volumeRestant = 0;

	private boolean autoRemplissage = Boolean.FALSE;

	private VolumemeterUsage volumemetreUsage;

	private WeightSensorUsage weightSensorUsage;

	private PressuremeterUsage pressuremetreUsage;

	private String composition;

	private String lineType = Media.LineType.SILICONE_10L.name();

	private ValveUsage controlValve ;

	protected List<IntakeUsage> aliasList = new LinkedList<>();

	private Long calibrationDateId = null;

	public IntakeUsage(UUID id, Intake componant, String name, Point location) {
		super(id, componant, name,location);
	}
	
}

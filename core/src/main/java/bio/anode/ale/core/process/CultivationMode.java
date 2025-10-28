package bio.anode.ale.core.process;

import java.util.LinkedList;
import java.util.List;

import bio.anode.ale.core.capability.TemperatureRegulation;
import bio.anode.ale.core.hypervision.Overseer;
import bio.anode.ale.core.usage.fluidic.ChamberUsage;

public class CultivationMode {
    protected List<ChamberUsage> chambers;
	protected List<TriggerableWorkflow> tasks;
	protected List<TemperatureRegulation> regulations;
	protected List<Overseer> overseers = new LinkedList<>();
	protected List<Operation> dilutions = new LinkedList<>();
	protected List<Operation> inoculations = new LinkedList<>();
	protected List<Operation> storyboardsDePrelevement = new LinkedList<>();
	protected double gasFlowrate;
	protected int samples = 2;
}

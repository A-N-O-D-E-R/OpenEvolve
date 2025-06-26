package bio.anode.ale.core.process.step;

import java.util.Set;

import com.anode.workflow.entities.steps.responses.RouteResponse;

import bio.anode.ale.core.usage.fluidic.valve.ValveUsage;

public class DilutionPulseStep extends FluidicStep {
    
    private double wastedVolume = 0 ;
	private double minimalVolume = 0 ;

    public DilutionPulseStep(Set<ValveUsage> activations) {
        super(activations);
        //TODO Auto-generated constructor stub
    }


    @Override
    public RouteResponse executeRoute() {
        return super.executeRoute();
        //TODO ; add notifcation for dilution Completed and handle weight delta to get dilution gap
    }
}

package bio.anode.ale.service;

import java.util.ArrayList;

import bio.anode.ale.core.component.fluidic.FluidicComponant;
import bio.anode.ale.core.usage.fluidic.AbstractFluidicUsage;
import bio.anode.ale.core.usage.fluidic.FluidicComponantUsage;

public class Test implements AbstractTopologyTest {
    
    public void test(){
        ArrayList<FluidicComponantUsage> usages = new ArrayList<>();
        usages.addAll(generatedChamberUsages());
        usages.addAll(generatedEvacuationUsages());
        usages.addAll(generatedIntakeUsages());
        usages.addAll(generatedJunctionUsages());
        usages.addAll(generatedTrapUsages());
        usages.addAll(generatedValveUsages());
        handleConnection(usages);
        usages.stream().filter(usage -> !(usage.isCompletelyConnected())).forEach(usage -> System.out.println(usage.getName()+"  current connections: "+((AbstractFluidicUsage)usage).getConnections().size()+" on "+((FluidicComponant) usage.getComponent()).getConnectorCount()));
    }

    public static void main(String[] args){
        new Test().test();
 
    }
}

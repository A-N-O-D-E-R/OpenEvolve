package bio.anode.ale.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import bio.anode.ale.core.Circuit;
import bio.anode.ale.core.component.fluidic.Intake;
import bio.anode.ale.core.exception.IllegalTopologyException;
import bio.anode.ale.core.hardware.FluidicTopology;
import bio.anode.ale.core.usage.fluidic.AbstractFluidicUsage;
import bio.anode.ale.core.usage.fluidic.Connection;
import bio.anode.ale.core.usage.fluidic.FluidicComponantUsage;
import bio.anode.ale.core.usage.fluidic.IntakeUsage;
import bio.anode.ale.service.fluidic.circuit.FluidicCircuitService;
import bio.anode.ale.service.fluidic.circuit.FluidicPathVisitor;

@TestInstance(Lifecycle.PER_CLASS)
public class FluidicCircuitServiceTest implements AbstractTopologyTest {

    private static String VALVE_WATER_REFILLING = "X1";
    private static String VALVE_MEDIUM_PRESSURE_RELEASE = "X5";
    private static String VALVE_OXONIA = "X05";
    private static String OXONIA_INTAKE = "O";

    private FluidicTopology topology;
    
    @BeforeAll
    void setUp() {
        ArrayList<FluidicComponantUsage> usages = new ArrayList<>();
        usages.addAll(generatedChamberUsages());
        usages.addAll(generatedEvacuationUsages());
        usages.addAll(generatedIntakeUsages());
        usages.addAll(generatedJunctionUsages());
        usages.addAll(generatedTrapUsages());
        usages.addAll(generatedValveUsages());
        handleConnection(usages);
        topology = new FluidicTopology(UUID.randomUUID(),usages);
    }

 
    @DisplayName("All components should be fully connected")
    @Test
    void testTopologyFullyConnected() {
        assertAll("All components should be fully connected",
            topology.getComposantFluidiqueUsages().stream().filter(usage -> !List.of(VALVE_WATER_REFILLING,VALVE_MEDIUM_PRESSURE_RELEASE,VALVE_OXONIA,OXONIA_INTAKE).contains(usage.getName())).map(usage ->
                () -> assertTrue(usage.isCompletelyConnected(), "the component "+usage.getName()+" with id \""+usage.getId()+"\" is not fully connected")
            )
        );
    }


    @DisplayName("Topolgy should be not cyclic")
    @Test
    Circuit testAcyclicPath() throws IllegalTopologyException{
        FluidicComponantUsage mediaOneIntakeUsage =  getUsageById(topology.getComposantFluidiqueUsages().stream().collect(Collectors.toList()), UUID.fromString("0197a111-ed96-77cc-8d6e-506ca50491ef"));
        Connection initialConnection = mediaOneIntakeUsage.getConnection(0);

            FluidicPathVisitor path = new FluidicPathVisitor(initialConnection);
            Circuit circuit = new FluidicCircuitService().getCircuit(((AbstractFluidicUsage) initialConnection.getTarget()),path);
            circuit.setRoot(mediaOneIntakeUsage);
            circuit.buildFinished();
            System.out.println(circuit);
            return circuit;

    }


    
    @DisplayName("Circuit Discovery")
    @Test
    public void testCircuitDiscovery() throws IllegalTopologyException {
        IntakeUsage soda = null;
        for (FluidicComponantUsage usage : topology.getComposantFluidiqueUsages()) 
            if (usage instanceof IntakeUsage) { 
                IntakeUsage intakeUsage = (IntakeUsage) usage;
                if (((Intake) intakeUsage.getComponent()).getType() == Intake.Type.SODA) 
                    soda = intakeUsage; 
            }
	    List<Circuit> circuits = new FluidicCircuitService().discoverCircuitsFrom(soda);
    
        System.out.println(circuits.size() + " circuits trouves");
        
        for (int i = 0; i < circuits.size(); i++)
            if(circuits.get(i).getChamberCount() > 1) 
                circuits.remove(i--);

        Set<Double> weights = new HashSet<Double>(); 
        for (Circuit circuit : circuits)
            weights.add(circuit.getWeight());
        
        System.out.println(weights.size() + " poids differents"); 
        for (Double weight : weights) 
            System.out.println(weight);
        
        Set<Double> lengths = new HashSet<Double>(); 
        for (Circuit circuit : circuits) 
            lengths.add(circuit.getTubeLength());
        
        System.out.println("\n" + lengths.size() + " longueurs differentes"); 
        for (Double length : lengths) 
            System.out.println(length); //

        //new FluidicCircuitService().discoverCircuits((AbstractFluidicUsage) soda.getConnections().get(0).getTarget(), new FluidicPathVisitor(soda.getConnections().get(0)));
    }
    
    
}

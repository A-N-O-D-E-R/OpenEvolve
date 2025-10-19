package bio.anode.ale.service.cytoscape.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bio.anode.ale.core.usage.fluidic.AbstractFluidicUsage;
import bio.anode.ale.core.usage.fluidic.FluidicComponantUsage;

public class Graph {
    private List<Data> nodes;
    private List<Data> edges;

    public Graph(List<FluidicComponantUsage> topology ){
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        for(FluidicComponantUsage usage : topology){
            nodes.add(new Data(usage));
            edges.addAll(((AbstractFluidicUsage)usage).getConnections().stream().map(Data::new).collect(Collectors.toList()));
        }
    }
}

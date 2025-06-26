package bio.anode.ale.core.hardware;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.UUID;

import com.anode.tool.persistance.Persistable;
import bio.anode.ale.core.usage.fluidic.FluidicComponantUsage;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class FluidicTopology implements Persistable, Serializable  {
    private UUID id;
    private Collection<FluidicComponantUsage> composantFluidiqueUsages = new LinkedList<>() ;
}

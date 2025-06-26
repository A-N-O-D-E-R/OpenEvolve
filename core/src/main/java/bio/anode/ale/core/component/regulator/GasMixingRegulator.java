package bio.anode.ale.core.component.regulator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GasMixingRegulator {
    
    private Regulator firstGas ;
    private Regulator secondGas ;
}
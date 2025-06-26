package bio.anode.ale.core.process.trigger;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TemporalTrigger implements Trigger {
    private UUID id;
    private String temporalDefinition;
    
}

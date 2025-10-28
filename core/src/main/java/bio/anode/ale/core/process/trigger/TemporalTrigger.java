package bio.anode.ale.core.process.trigger;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TemporalTrigger implements Trigger {
    private Serializable id;
    private String temporalDefinition;
    
}

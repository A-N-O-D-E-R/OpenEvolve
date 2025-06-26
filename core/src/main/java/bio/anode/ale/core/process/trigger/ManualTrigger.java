package bio.anode.ale.core.process.trigger;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManualTrigger implements Trigger {
    UUID id;
    public ManualTrigger(){
        id=UUID.fromString("00000000-0000-0000-0000-000000000000");
    }
}

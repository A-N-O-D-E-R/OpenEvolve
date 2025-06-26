package bio.anode.ale.core.process;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.anode.tool.persistance.Persistable;
import com.anode.workflow.entities.workflows.WorkflowDefinition;

import bio.anode.ale.core.culture.Culture;
import bio.anode.ale.core.hardware.Hardware;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

public class Process implements Persistable {
    UUID id;
    private int version;
    private String name;
    private String build = "-";
    
    Hardware hardware;

    List<Operation> storyboards = new LinkedList<>();

    List<Culture> cultures;

}

package bio.anode.ale.service;

import java.util.UUID;

import com.anode.tool.service.CommonService;
import com.anode.workflow.entities.steps.Step;
import com.anode.workflow.entities.workflows.WorkflowDefinition;

import bio.anode.ale.core.process.trigger.Trigger;
import bio.anode.ale.core.process.TriggerableWorkflow;

public interface ProcessService extends CommonService {

    public Process getProtocole(UUID identifiant);

    public void deleteProtocole(Process protocole);

    public TriggerableWorkflow getTache(UUID identifiant);

    public Trigger getDeclencheur(UUID identifiant);

    public WorkflowDefinition getOperation(UUID identifiant);
    
    public Step getEtape(UUID identifiant);
} 
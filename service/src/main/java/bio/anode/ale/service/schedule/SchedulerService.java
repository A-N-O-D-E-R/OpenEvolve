package bio.anode.ale.service.schedule;

import org.quartz.Job;

import bio.anode.ale.core.process.TriggerableWorkflow;

public interface SchedulerService {
    public void load(Process protocole) throws ParseException ;

    public void shutdown() throws IllegalStateException;    

    public void pause() ;    

    public void resume() ;    

    public List<Planning> getPlanning(Date until, TriggerableWorkflowFilter filter);
    
    public Date getProchainDeclenchement(TriggerableWorkflow tache) ;
    
    public List<Date> getTriggers(TriggerableWorkflow tache, Date from, Date to) ;
    
    public void scheduleWorkflow(Class<? extends Job> jobClass, String taskId, String cronDefinition) ;

    public void unscheduleWorkflow(String taskId) ;
}

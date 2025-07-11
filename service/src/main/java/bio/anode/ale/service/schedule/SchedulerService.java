package bio.anode.ale.service.schedule;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.quartz.Job;

import bio.anode.ale.core.filter.process.TriggerableWorkflowFilter;
import bio.anode.ale.core.process.TriggerableWorkflow;
import bio.anode.ale.core.specifications.Planning;

public interface SchedulerService {
    public void load(Process protocole) throws ParseException ;

    public void shutdown() throws IllegalStateException;    

    public void pause() ;    

    public void resume() ;    

    public List<Planning> getPlanning(Date until, TriggerableWorkflowFilter filter);
    
    public Date getNextTriggerDate(TriggerableWorkflow tache) ;
    
    public List<Date> getTriggers(TriggerableWorkflow tache, Date from, Date to) ;
    
    public void scheduleWorkflow(Class<? extends Job> jobClass, String taskId, String cronDefinition) ;

    public void unscheduleWorkflow(String taskId) ;
}

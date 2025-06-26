package bio.anode.ale.core.specifications;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Builder;

@Builder
public class Experiment {
    private Date startingDate;
    private Date endingDate;
    private Integer projectId;
    private Integer sequenceId;
    private Integer experimentId;

    public String getExperimentCode(){
        return "P"+projectId+"-S"+sequenceId+"-E"+experimentId;
    }

    public List<String> getSampleCode(Date samplingDate, Integer numberOfAliquots) throws Exception{
        if(samplingDate.compareTo(startingDate)<0)
            throw new Exception("sampling date cannot be before starting date");
        List<String> sampleStrings = new ArrayList<>();
        for(Integer samplingNumber=1;samplingNumber<=numberOfAliquots;samplingNumber++){
            sampleStrings.add(getExperimentCode()+"-T"+(samplingDate.getTime()-startingDate.getTime())+"_"+samplingNumber);
        }
        return sampleStrings;
    }

    public boolean isActive(){
        return endingDate==null;
    }
}

package bio.anode.ale.core.specifications;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import bio.anode.ale.core.process.TriggerableWorkflow;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Planning implements Serializable {
	private TriggerableWorkflow workflow;
	private List<Date> dates;
}
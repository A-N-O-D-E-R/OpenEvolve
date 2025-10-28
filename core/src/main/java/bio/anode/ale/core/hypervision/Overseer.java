package bio.anode.ale.core.hypervision;

import java.io.Serializable;
import java.util.UUID;

import com.anode.tool.event.EventManager;
import com.anode.tool.event.EventProducer;
import com.anode.tool.persistance.Persistable;
import com.anode.workflow.service.runtime.RuntimeService;

import bio.anode.ale.core.culture.Culture;
import bio.anode.ale.core.process.CultivationMode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Overseer implements Persistable {
    private Serializable id;
    private String name ;
	private char[] code ;
    private int priorite ;
	private Process process ;
	private Culture culture ;
	private CultivationMode protocoleDeCulture ;
	private transient RuntimeService runtime ;
	private boolean active ;
	private transient EventProducer eventProducer;
	private transient EventManager eventManager;

}

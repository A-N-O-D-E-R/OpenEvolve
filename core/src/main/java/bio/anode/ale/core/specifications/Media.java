package bio.anode.ale.core.specifications;

import java.io.Serializable;
import java.util.UUID;

import com.anode.tool.persistance.Persistable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Media implements Serializable,Persistable {
    private UUID id;
    private String code;
	private String alternativeCode = "";
	private String label = "";
	private double viscosity;
	private double density;
    
    public enum LineType {
		SILICONE_10L("Silicone 10l"),TEFLON_10L("Teflon 10l") ;
		
		String label ;
		
		LineType(String label) {
			this.label = label ;
		}
		
		public String getLabel() {
			return label;
		}
	}
}

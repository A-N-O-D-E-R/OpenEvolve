package bio.anode.ale.core.hardware;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.specifications.BuildVersion;
import bio.anode.ale.core.specifications.Model;
import bio.anode.ale.core.usage.EmbededComputeUsage;
import bio.anode.ale.core.usage.actuator.ActuatorUsage;
import bio.anode.ale.core.usage.regulator.RegulatorUsage;
import bio.anode.ale.core.usage.sensor.SensorUsage;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/*
 * This is the root component, it describe all the Hardware component and usage 
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Hardware extends Component  {

    public Hardware(UUID id, Model model, String serialNumber, int version) {
        super(id, model, serialNumber, version);
    }
    private String name;
    private Date deployementDate;
    private BuildVersion build;
    private EmbededComputeUsage computeUsage;
    private FluidicTopology topology;
    private Collection<ActuatorUsage> actuatorUsages;
    private Collection<SensorUsage> sensorUsages;
    private Collection<RegulatorUsage> regulatorUsages;

}

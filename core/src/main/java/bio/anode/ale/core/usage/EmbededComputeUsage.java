package bio.anode.ale.core.usage;

import java.util.UUID;

import bio.anode.ale.core.component.Component;
import bio.anode.ale.core.usage.sensor.MemorymeterUsage;
import bio.anode.ale.core.usage.sensor.ThermometerUsage;

public class EmbededComputeUsage  extends NetworkComponantUsage {
    private CPUArchitecture arch;
    private OSType os;
    private ThermometerUsage thermometerCpuUsage;
    private MemorymeterUsage memorymetreRAMUsage;
    private MemorymeterUsage memorymetreDisqueUsage;
    private MemorymeterUsage memorymetreHeapUsage;
    
    public EmbededComputeUsage(UUID identifiant, Component component, String name, String adress) {
        super(identifiant, component, name, adress);
    }

    public enum CPUArchitecture{
        X86_64,
        ARM;
    }

    public enum OSType{
        DOS,
        UNIX,
        DARWIN;
    }
}

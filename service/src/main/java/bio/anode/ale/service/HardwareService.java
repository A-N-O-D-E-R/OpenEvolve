package bio.anode.ale.service;

import java.util.List;
import java.util.UUID;

import bio.anode.ale.core.component.NetworkComponant;
import bio.anode.ale.core.component.sensor.Sensor;
import bio.anode.ale.core.hardware.Hardware;
import bio.anode.ale.core.usage.ComponentUsage;
import com.anode.tool.service.CommonService;

public interface HardwareService extends CommonService {

    public Hardware getHardware(UUID identifiant);

    public void deleteHardware(Hardware hw);

    public Sensor getSensor(UUID identifiant);

    public NetworkComponant getNetworkComponant(UUID identifiant);

	public List<ComponentUsage> getComposantUsages(Class<? extends ComponentUsage> type,String name) ;
    
}


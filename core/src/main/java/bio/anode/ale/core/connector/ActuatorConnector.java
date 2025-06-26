package bio.anode.ale.core.connector;


public interface ActuatorConnector {
    
    public void writeCmd(String cmd, String address);
} 

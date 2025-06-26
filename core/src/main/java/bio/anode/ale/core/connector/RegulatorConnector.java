package bio.anode.ale.core.connector;

import bio.anode.ale.core.exception.CommunicationException;

public interface RegulatorConnector {
    public void setThreshold(double consigne) throws CommunicationException;
	public double getThreshold() throws CommunicationException;
}

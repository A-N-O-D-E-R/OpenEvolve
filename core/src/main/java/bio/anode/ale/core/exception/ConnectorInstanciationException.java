package bio.anode.ale.core.exception;

public class ConnectorInstanciationException extends Exception {
    
    public ConnectorInstanciationException() {
        super();
    }
    public ConnectorInstanciationException(String message) {
        super(message);
    }

    public ConnectorInstanciationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectorInstanciationException(Throwable cause) {
        super(cause);
    }
}


package bio.anode.ale.core.exception;

public class IllegalTopologyException extends Exception{
     
    public IllegalTopologyException() {
        super();
    }
    public IllegalTopologyException(String message) {
        super(message);
    }

    public IllegalTopologyException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalTopologyException(Throwable cause) {
        super(cause);
    }
}

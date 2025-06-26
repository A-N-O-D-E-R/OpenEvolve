package bio.anode.ale.core.event;

public interface EventProducer {	
	
    public void addEventListener(EventListener listener, EventListenerFilter filter);

    public void removeEventListener(EventListener listener);
}

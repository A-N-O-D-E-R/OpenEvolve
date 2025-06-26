package bio.anode.ale.core.event;

public interface EventFieldGetter<T extends Event, C> {
	public C get(T event) ;
}

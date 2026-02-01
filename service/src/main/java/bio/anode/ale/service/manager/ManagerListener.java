package bio.anode.ale.service.manager;

public interface ManagerListener {
    default void onStarted(Manager manager) {}
    default void onStopped(Manager manager) {}
}
package bio.anode.ale.service.manager;

public interface Manager {
    String getManagerId(); // replaces ObjectName
    void start() throws Exception;
    void stop();
}
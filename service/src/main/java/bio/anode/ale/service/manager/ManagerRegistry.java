package bio.anode.ale.service.manager;

public interface ManagerRegistry {
    public void register(Manager manager);

    public void unregister(Manager manager);

    public Manager get(String id);
}

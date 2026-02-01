package bio.anode.ale.service.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryManagerRegistry implements ManagerRegistry {

    private static final Map<String, Manager> managers = new ConcurrentHashMap<>();

    private static ManagerRegistry instance;

    public static ManagerRegistry getInstance(){
        if(instance!=null){
            return instance;
        }
        instance = new MemoryManagerRegistry();
        return instance;
    }


    protected MemoryManagerRegistry(){
    }
    @Override
    public void register(Manager manager) {
        managers.put(manager.getManagerId(), manager);
    }

    @Override
    public void unregister(Manager manager) {
        managers.remove(manager.getManagerId());
    }

    @Override
    public Manager get(String id) {
        return managers.get(id);
    }
}

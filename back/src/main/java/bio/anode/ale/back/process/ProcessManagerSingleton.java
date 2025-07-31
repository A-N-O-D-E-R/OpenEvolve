package bio.anode.ale.back.process;

import bio.anode.ale.service.manager.ProcessManager;

public class ProcessManagerSingleton {
    private static ProcessManager instance;

    public static ProcessManager getIntance(){
        if (instance!=null){
            return instance;
        }
        
    }
} 

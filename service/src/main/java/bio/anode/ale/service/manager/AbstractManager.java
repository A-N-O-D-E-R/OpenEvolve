package bio.anode.ale.service.manager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractManager implements Manager {


    protected boolean started = false;
    private ManagerListener listener;
    private ManagerRegistry registry;

    public AbstractManager() {
        this.registry = MemoryManagerRegistry.getInstance();
    }
    public AbstractManager(ManagerListener listener) {
        this.listener = listener;
        this.registry = MemoryManagerRegistry.getInstance();
    }

    public AbstractManager(ManagerListener listener, ManagerRegistry registry) {
        this.listener = listener;
        this.registry = registry;
    }

    public AbstractManager(ManagerRegistry registry) {
        this.registry = registry;
    }


    @Override
    public synchronized void start() throws Exception {
        if (started) {
            log.warn("Manager already started: ignored");
            return;
        }

        registry.register(this);
        beforeStart();
        started = true;

        if (listener != null) listener.onStarted(this);

        log.debug("Manager " + getManagerId() + " started");
    }

    @Override
    public synchronized void stop() {
        if (!started) {
            log.warn("Manager not started: ignored");
            return;
        }

        beforeStop();
        registry.unregister(this);
        started = false;

        if (listener != null) listener.onStopped(this);

        log.debug("Manager " + getManagerId() + " stopped");
    }

    protected void beforeStart() throws Exception {}
    protected void beforeStop() {}
}

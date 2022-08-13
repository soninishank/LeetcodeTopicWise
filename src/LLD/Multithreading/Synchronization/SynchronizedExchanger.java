package LLD.Multithreading.Synchronization;

public class SynchronizedExchanger {
    protected Object object = null;

    // it means the monitor object is on  SynchronizedExchanger instance
    public synchronized void setObject(Object o) {
        this.object = o;
    }

    public synchronized Object getObject() {
        return this.object;
    }

    public void setObj(Object o) {
        synchronized (this) // blocks can be used to monitor for any java instance
        {
            this.object = o;
        }
    }

    public Object getObj() {
        synchronized (this) {
            return this.object;
        }
    }
}

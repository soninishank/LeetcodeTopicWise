package LLD.Multithreading.ThreadCreation;

public class ImplementLock {
    boolean taken = false;
    String threadName;

    void lock() throws InterruptedException {
        while (taken) {
            Thread.sleep(100);
        }
        taken = true;
        threadName = Thread.currentThread().getName();
    }

    void unlock() {
        if (Thread.currentThread().getName().equals(this.threadName)) {
            taken = false;
            threadName = "";
        } else {

        }
    }
}

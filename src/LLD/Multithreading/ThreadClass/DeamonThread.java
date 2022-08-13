package LLD.Multithreading.ThreadClass;

// https://stackoverflow.com/questions/2213340/what-is-a-daemon-thread-in-java
// A daemon thread is a thread that does not prevent the JVM from exiting when the program finishes but the thread is still running. An example for a daemon thread is the garbage collection.
//You can use the setDaemon(boolean) method to change the Thread daemon properties before the thread starts.
public class DeamonThread {
    // even if main thread is stopped the remaining threads will keep on running
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Runnable " + Thread.currentThread().getName());
                }
            }
        };
        Thread runnableThread = new Thread(runnable);
        runnableThread.setDaemon(true);// you need to mark it true , comment it for testing - will stop all daemon threads
        runnableThread.start();
        Thread.sleep(3000);// after this main thread should have terminated
    }
}

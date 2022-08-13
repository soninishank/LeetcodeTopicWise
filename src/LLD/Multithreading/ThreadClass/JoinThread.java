package LLD.Multithreading.ThreadClass;

// t1.join() means, t1 says something like "I want to finish first". Same is the case with t2. No matter who started t1 or t2 thread (in this case the main method), main will wait until t1 and t2 finish their task.
// However, an important point to note down, t1 and t2 themselves can run in parallel irrespective of the join call sequence on t1 and t2. It is the main/daemon thread that has to wait.
// https://stackoverflow.com/questions/15956231/what-does-this-thread-join-code-mean
// Threads in java are managed by the underlying JVM 
public class JoinThread {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("The first thread is " + i + " " + Thread.currentThread().getName());
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("The runnable1  is " + i + " " + Thread.currentThread().getName());
                }
            }
        };
        Thread t2 = new Thread(runnable1);
        // out of order execution
        t1.start();
        t1.join(); // wait for t1 thread to finish then proceed further
        t2.start();

    }
}

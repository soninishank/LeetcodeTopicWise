package LLD.Multithreading.ThreadLocal;

// it can share the values with the child threads
public class InheritedThreadLocal {


    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread thread1 = new Thread(() -> {
            System.out.println("=== Thread 1");
            threadLocal.set("thread-1 - local");
            inheritableThreadLocal.set("Thread1 - inheritableThreadLocal");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            System.out.println();

            Thread childThread = new Thread(() -> {
                System.out.println("=== child thread ===");
                System.out.println(threadLocal.get()); // will give null
                System.out.println(inheritableThreadLocal.get()); // value is already set in parent thread
            });
            childThread.start();
        });

        thread1.start();
    }

}

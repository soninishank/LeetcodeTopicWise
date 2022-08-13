package LLD.Multithreading.ThreadLocal;

// For each thread there will be a one threadLocal
// 100 task - 10 thread pools - 10 thread locals - so task will be sharing the same thread values
public class ThreadLocalBasicExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread thread1 = new Thread(() -> {
            threadLocal.set("thread-1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String value = threadLocal.get();
            //threadLocal.remove();
            System.out.println(value); // - will return null if removed is used
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            threadLocal.set("thread-2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String value = threadLocal.get();
            //threadLocal.remove();
            System.out.println(value);// - will return null if removed is used
        });
        thread2.start();

    }
}

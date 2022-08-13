package LLD.Multithreading.EvenOdd.UsingSemaphore;

import java.util.concurrent.Semaphore;

public class SharedPrinter {
    private final Semaphore semEven = new Semaphore(0);
    private final Semaphore semOdd = new Semaphore(1);

    void printEvenNum(int num) {
        try {
            if (semEven.tryAcquire())
            semEven.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + ":" + num);
        semOdd.release();
    }

    void printOddNum(int num) {
        try {
            semOdd.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + ":" + num);
        semEven.release();
    }
}

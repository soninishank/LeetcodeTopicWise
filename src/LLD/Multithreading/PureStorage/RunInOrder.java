package LLD.Multithreading.PureStorage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// To run a multithreaded code in order
// The join() method is used to enforce order. thread1.join() ensures that thread1 (which calls apiIncrement) completes before thread2
// (which calls apiDecrement) starts.Similarly, thread2.join() ensures that apiDecrement completes before apiDouble starts, and so on.

public class RunInOrder {
    // Shared variable
    private static int sharedVariable = 0;

    // Lock object to control access to the shared variable
    private static final Lock lock = new ReentrantLock();

    // API 1: Increments the shared variable
    public static void apiIncrement() {
        lock.lock(); // Acquiring the lock
        try {
            System.out.println("API 1: Lock acquired, incrementing the shared variable.");
            int currentValue = sharedVariable;
            try {
                // Simulating some work with sleep
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedVariable = currentValue + 1;
            System.out.println("API 1: New shared variable value is " + sharedVariable);
        } finally {
            lock.unlock(); // Releasing the lock
        }
    }

    // API 1: Increments the shared variable
    public static void apiIncrementWithoutLock() {
        System.out.println("API 1: Lock acquired, incrementing the shared variable.");
        int currentValue = sharedVariable;
        try {
            // Simulating some work with sleep
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        sharedVariable = currentValue + 1;
        System.out.println("API 1: New shared variable value is " + sharedVariable);
    }

    // API 2: Decrements the shared variable
    public static void apiDecrement() {
        lock.lock(); // Acquiring the lock
        try {
            System.out.println("API 2: Lock acquired, decrementing the shared variable.");
            int currentValue = sharedVariable;
            try {
                // Simulating some work with sleep
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedVariable = currentValue - 1;
            System.out.println("API 2: New shared variable value is " + sharedVariable);
        } finally {
            lock.unlock(); // Releasing the lock
        }
    }

    // API 3: Doubles the shared variable
    public static void apiDouble() {
        lock.lock(); // Acquiring the lock
        try {
            System.out.println("API 3: Lock acquired, doubling the shared variable.");
            int currentValue = sharedVariable;
            try {
                // Simulating some work with sleep
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedVariable = currentValue * 2;
            System.out.println("API 3: New shared variable value is " + sharedVariable);
        } finally {
            lock.unlock(); // Releasing the lock
        }
    }

    // Function to simulate calling the APIs concurrently
    public static void callApis() {
        // Creating threads for concurrent API calls
        Thread thread1 = new Thread(DeadlockFreeAPIs::apiIncrement);
        Thread thread2 = new Thread(DeadlockFreeAPIs::apiDecrement);
        Thread thread3 = new Thread(DeadlockFreeAPIs::apiDouble);


        // Waiting for threads to complete
        try {
            thread1.start();
            thread1.join(); // Ensure thread1 completes before starting thread2

            thread2.start();
            thread2.join(); // Ensure thread2 completes before starting thread3

            thread3.start();
            thread3.join(); // Ensure thread3 completes before finishing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        callApis();
    }

}

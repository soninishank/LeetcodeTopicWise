package LLD.Multithreading.EvenOdd;

import LLD.Multithreading.EvenOdd.WithSynchronization.EvenOddSynchronization;
import LLD.Multithreading.EvenOdd.WithoutSynchronization.EvenOddWithoutSynchronization;

// Here we are just using a boolean variable isOdd. This value gets toggled after each thread prints a value.
public class ThreadOddEven {
    public static void main(String[] args) {
        EvenOddWithoutSynchronization withoutSynchronization = new EvenOddWithoutSynchronization();
        EvenOddSynchronization withSynchronization = new EvenOddSynchronization();

        // with lambda
        Thread t1 = new Thread(() ->
                withSynchronization.printOdd());
        t1.setName("odd");

        // without lambda
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                withSynchronization.printEven();
            }
        });
        t2.setName("even");
        t1.start();
        t2.start();
    }
}

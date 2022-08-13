package LLD.Multithreading.ThreadClass;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CreatingThread {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("My thread running  " + Thread.currentThread().getName());
            System.out.println("My thread stopped  " + Thread.currentThread().getName());
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("My runnable running  " + Thread.currentThread().getName());
            System.out.println("My runnable stopped  " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        System.out.println("Current thread " + Thread.currentThread().getName());
        // 1.USING THREAD CLASS
        MyThread threadClass = new MyThread();
        threadClass.start();

        // if you call run() directly it will call run() in same thread
        System.out.println(); // order is not fixed so it will come at any place
        // you can't call runnable class directly if you need a run()

        // 2.USING RUNNABLE INTERFACE
        MyRunnable runnable = new MyRunnable();
        Thread runnableThread = new Thread(runnable);
        runnableThread.start();

        // 3.USING ANONYMOUS INNER CLASS
        Runnable runnableInnerClass = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnableInnerClass running  " + Thread.currentThread().getName());
                System.out.println("runnableInnerClass stopped  " + Thread.currentThread().getName());
            }
        };
        Thread runnableInnerObj = new Thread(runnableInnerClass);
        runnableInnerObj.start();



        // 4.Using Lambda expression
        Runnable runnableLambda = () -> {
            System.out.println("runnableLambda running  " + Thread.currentThread().getName());
            System.out.println("runnableLambda stopped  " + Thread.currentThread().getName());
        };
        Thread lambda = new Thread(runnableLambda);
        lambda.start();


        // 5.using callable interface - requires executor service
        try {
            Callable<Integer> callable = new Callable<Integer>() {
                @Override
                public Integer call() {
                    System.out.println("callable running  " + Thread.currentThread().getName());
                    System.out.println("callable stopped  " + Thread.currentThread().getName());
                    return 10;
                }
            };
            FutureTask<Integer> integerFutureTask = new FutureTask<>(callable);
            Thread t = new Thread(integerFutureTask);
            t.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

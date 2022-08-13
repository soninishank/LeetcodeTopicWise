package LLD.Multithreading.Synchronization;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// How parameters work
// If you want to control synchronization to a specific object, or you only want part of a method to be synchronized to the object, then specify a synchronized block. If you use the synchronized keyword on the method declaration, it will synchronize the whole method to the object or class.
// https://stackoverflow.com/questions/20906548/why-is-synchronized-block-better-than-synchronized-method#:~:text=One%20classic%20difference%20between%20Synchronized,the%20code%20within%20the%20block.

public class SynchronizedBlock {

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private HashMap<String, Lock> hashMap;

    public SynchronizedBlock() {
        hashMap = new HashMap<>();
        hashMap.put("nishank", lock1);
        hashMap.put("soni", lock2);
    }

    // on a specific user
    private void checkParam(String name) {
        if (hashMap.containsKey(name) && name.equals("nishank")) {
            synchronized (hashMap.get(name)) {
                System.out.println("I am in synchronized block for user " + name);
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new SynchronizedBlock().checkParam("nishank");
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                new SynchronizedBlock().checkParam("soni");
            }
        };
        Thread t2 = new Thread(runnable1);
        t2.start();
    }
}

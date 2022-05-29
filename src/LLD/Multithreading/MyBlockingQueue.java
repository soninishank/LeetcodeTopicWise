package LLD.Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// we need to protect from simultaneous access
// using lock and conditions
public class MyBlockingQueue<E> {

    private Queue<E> queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();


    public MyBlockingQueue(int size) {
        this.queue = new LinkedList<>();
        this.max = size;
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            if (queue.size() == max) {
                // block the thread
                notFull.await();
            }
            queue.add(e); // protected by lock
        } finally {
            lock.unlock();
        }

    }

    public E take() throws InterruptedException {
        lock.lock(); // acquiring the lock
        try {
            if (queue.size() == 0) {
                // block the thread
                notEmpty.await();
            }
            E remove = queue.remove();
            return remove;
        } finally {
            lock.unlock();// releasing the lock
        }
    }
}

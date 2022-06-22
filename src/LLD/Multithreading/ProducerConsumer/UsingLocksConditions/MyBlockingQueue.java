package LLD.Multithreading.ProducerConsumer.UsingLocksConditions;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
    private Queue<E> queue;
    private int max;
    private Lock reentrantLock = new ReentrantLock(true);
    private Condition queueNotEmpty = reentrantLock.newCondition();
    private Condition queueNotFull = reentrantLock.newCondition();


    public MyBlockingQueue(int size) {
        this.queue = new LinkedList<>();
        this.max = size;
    }

    public void put(E e) {
        reentrantLock.lock();
        try {
            // if queue size is full then you can't push - we need to block the thread
            if (queue.size() == max) {
                queueNotFull.await(); // it is waiting for someone to say that queue is not full
            }
            queue.add(e);
            queueNotEmpty.signalAll();// sending a signal to consumer thread that it's not empty anymore
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() {
        reentrantLock.lock();
        try {
            // if queue is empty - than you can't consume - we need to block the thread
            while (queue.size() == 0) {
                queueNotEmpty.await(); // it is waiting for someone to say that queue is not empty
            }
            E item = queue.remove();
            queueNotFull.signalAll();// sending a signal to producer thread that it's not full anymore
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }
}

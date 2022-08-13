package LLD.Multithreading.ProducerConsumer.UsingLocksConditions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueUsingCondition<E> {
    private final Queue<E> queue;
    private final int max;
    private final Lock reentrantLock = new ReentrantLock(true);
    private final Condition queueEmpty = reentrantLock.newCondition();
    private final Condition queueFull = reentrantLock.newCondition();

    public BlockingQueueUsingCondition(int size) {
        this.queue = new LinkedList<>();
        this.max = size;
    }

    public void put(E e) {
        reentrantLock.lock();
        try {
            // if queue size is full then you can't push - we need to block the thread
            if (queue.size() == max) {
                queueFull.await(); // it is waiting for someone to say that queue is not full
            }
            queue.add(e);
            queueEmpty.signalAll();// sending a signal to consumer thread that it's not empty anymore
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
                queueEmpty.await(); // it is waiting for someone to say that queue is not empty
            }
            E item = queue.remove();
            queueFull.signalAll();// sending a signal to producer thread that it's not full anymore
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }
}

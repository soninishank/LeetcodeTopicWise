package LLD.Multithreading.ProducerConsumer.UsingWaitNotify;

import java.util.LinkedList;
import java.util.Queue;

public class WaitNotify<E> {
    private final Queue<E> queue;
    private final int max;
    private final Object sharedQueue = new Object();


    public WaitNotify(int size) {
        this.queue = new LinkedList<>();
        this.max = size;
    }

    public void put(E e) {
        synchronized (sharedQueue) {
            try {
                // if queue size is full then you can't push - we need to block the thread
                if (queue.size() == max) {
                    sharedQueue.wait(); // it is waiting for someone to say that queue is not full
                }
                queue.add(e);
                sharedQueue.notifyAll();// sending a signal to consumer thread that it's not empty anymore
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public E take() {
        synchronized (sharedQueue) {
            try {
                // if queue is empty - than you can't consume - we need to block the thread
                while (queue.size() == 0) {
                    sharedQueue.wait(); // it is waiting for someone to say that queue is not empty
                }
                E item = queue.remove();
                sharedQueue.notifyAll();// sending a signal to producer thread that it's not full anymore
                return item;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

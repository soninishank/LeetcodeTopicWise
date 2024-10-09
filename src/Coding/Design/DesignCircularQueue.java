package Coding.Design;

import java.util.concurrent.locks.ReentrantLock;

public class DesignCircularQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int capacity;
    private ReentrantLock queueLock = new ReentrantLock();// Additional variable to secure the access of our queue

    public DesignCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        size = 0;
        head = 0;
        tail = -1;
    }

    public boolean enQueue(int value) {
        queueLock.lock();
        try {
            if (isFull()) {
                return false;
            }
            tail = (tail + 1) % capacity;
            queue[tail] = value;
            size++;
            return true;
        } finally {
            queueLock.unlock();
        }
    }

    public boolean deQueue() {
        queueLock.lock();
        try {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
            size--;
            return true;
        } finally {
            queueLock.unlock();
        }
    }

    public int Front() {
        queueLock.lock();
        try {
            if (isEmpty()) {
                return -1;
            }
            return queue[head];
        } finally {
            queueLock.unlock();
        }
    }

    public int Rear() {
        queueLock.lock();
        try {
            if (isEmpty()) {
                return -1;
            }
            return queue[tail];
        } finally {
            queueLock.unlock();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        DesignCircularQueue myCircularQueue = new DesignCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.deQueue();  // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.deQueue();  // return True


        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4

    }
}

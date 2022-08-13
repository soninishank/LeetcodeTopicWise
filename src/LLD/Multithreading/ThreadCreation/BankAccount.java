package LLD.Multithreading.ThreadCreation;

import java.util.concurrent.locks.Lock;

public class BankAccount {

    private final String name;
    private Integer amount;
    private final Lock lock;

    public BankAccount(String name, Integer val, Lock lock) {
        this.name = name;
        this.amount = val;
        this.lock = lock;
    }

    public void withdraw(int amount) {
        this.lock.lock();
        this.amount -= amount;
        this.lock.unlock();
    }

    public void deposit(int amount) {
        this.lock.lock();
        this.amount += amount;
        this.lock.unlock();
    }

    public int balance() {
        return this.amount;
    }
}

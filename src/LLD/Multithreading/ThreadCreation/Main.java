package LLD.Multithreading.ThreadCreation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        BankAccount aliceAccount = new BankAccount("Alice", 1000,lock);
        BankAccount bobAccount = new BankAccount("Alice", 1000,lock);

        AliceThread aliceThread = new AliceThread(aliceAccount, bobAccount);
        aliceThread.start(); // Causes this thread to begin execution - create a new thread

        BobThread bobThread = new BobThread(aliceAccount, bobAccount);
        bobThread.start();// another new thread

        // Join method will wait for the completion for both the thread execution
        aliceThread.join();
        bobThread.join();

        System.out.println("The alice balance is " + aliceAccount.balance());
        System.out.println("The bob balance is " + bobAccount.balance());
    }
}


// Three threads
// 1.Bob
// 2.alice
// 3.Main thread

// Two threads when trying to access the same variable - race condition - data inconsistency
// 1.lock
// 2.synchronized - you can apply lock on a block
//    public void withdraw(int amount) {
//        synchronized(this){
//        this.amount -= amount;
//        }
//    }
//
//    public void deposit(int amount) {
//        synchronized(this){
//        this.amount += amount;
//        }
//    }
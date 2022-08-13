package LLD.Multithreading.EvenOdd.UsingSemaphore;

public class PrintEvenOddSemaphore {
    public static void main(String[] args) {
        SharedPrinter sp = new SharedPrinter();
        Thread odd = new Thread(new Odd(sp, 10), "Odd No");
        Thread even = new Thread(new Even(sp, 10), "Even");

        odd.start();
        even.start();
    }
}

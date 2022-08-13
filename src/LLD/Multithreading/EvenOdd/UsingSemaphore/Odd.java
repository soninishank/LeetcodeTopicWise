package LLD.Multithreading.EvenOdd.UsingSemaphore;

public class Odd implements Runnable {
    private final SharedPrinter sp;
    private final int max;

    Odd(SharedPrinter sp, int max) {
        this.sp = sp;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 1; i <= max; i = i + 2) {
            sp.printOddNum(i);
        }
    }
}
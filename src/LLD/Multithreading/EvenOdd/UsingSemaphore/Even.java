package LLD.Multithreading.EvenOdd.UsingSemaphore;

public class Even implements Runnable {
    private final SharedPrinter sp;
    private final int max;

    Even(SharedPrinter sp, int max) {
        this.sp = sp;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 2; i <= max; i = i + 2) {
            sp.printEvenNum(i);
        }
    }
}
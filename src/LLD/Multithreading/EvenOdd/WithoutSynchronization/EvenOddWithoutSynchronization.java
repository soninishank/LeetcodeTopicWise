package LLD.Multithreading.EvenOdd.WithoutSynchronization;

// Here we are just using a boolean variable isOdd. This value gets toggled after each thread prints a value.
public class EvenOddWithoutSynchronization {
    private static int count = 1;
    private static final int MAX = 20;
    private boolean isOdd = true;

    public void printEven() {
        while (true) {
            if (count > MAX) break;
            if (isOdd == false) {
                System.err.println(Thread.currentThread().getName() + ":" + count++);
                isOdd = true;
            }
        }
    }

    public void printOdd() {
        while (true) {
            if (count > MAX) break;
            if (isOdd) {
                System.err.println(Thread.currentThread().getName() + ":" + count++);
                isOdd = false;
            }
        }
    }
}

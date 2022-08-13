package LLD.Multithreading.UditAgr;

public class Printer implements Runnable {

    private final int step;
    private final State state;
    private int currentValue;
    private final PrinterType currentPrinterType;
    private final PrinterType nextPrinterType;
    private final int maxValue;

    public Printer(final Integer currentValue, final int step, final State state,
                   final PrinterType currentPrinterType, final PrinterType nextPrinterType,
                   Integer maxValue) {
        this.currentValue = currentValue; // INITIAL VALUE
        this.step = step; // 2
        this.state = state; // current thread state either ODD or EVEN
        this.currentPrinterType = currentPrinterType;
        this.nextPrinterType = nextPrinterType;
        this.maxValue = maxValue;
    }


    public void run() {
        while (currentValue <= maxValue) {
            synchronized (state) { // ODD
                while (this.currentPrinterType != state.getNextToPrint()) {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(currentPrinterType.toString() + ": " + currentValue);
                currentValue += step;
                state.setNextToPrint(this.nextPrinterType);
                state.notifyAll();
            }
        }
    }
}

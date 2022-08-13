package LLD.Multithreading.RaceConditions;


public class RaceConditionExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(getRunnable(counter, " Thread1 final count"));
        Thread thread2 = new Thread(getRunnable(counter, " Thread2 final count"));

        thread1.start();
        thread2.start();
    }

    //    Thread1 final count 89302644
//    Thread2 final count 100024580
    private static Runnable getRunnable(Counter counter, String message) {
        return () -> {
            for (int i = 0; i < 1_00_00; i++) {
                counter.incAndGet();
            }
            System.out.println(message + " " + counter.get()); // everytime the value is different
        };
    }
}

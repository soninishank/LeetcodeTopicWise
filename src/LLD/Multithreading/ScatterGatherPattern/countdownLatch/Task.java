package LLD.Multithreading.ScatterGatherPattern.countdownLatch;

import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {
    private final String url;
    private final int productId;
    private final Set<Integer> prices;
    private final CountDownLatch latch;

    public Task(String url, int productId, Set<Integer> prices, CountDownLatch latch) {
        this.url = url;
        this.productId = productId;
        this.prices = prices;
        this.latch = latch;
    }

    @Override
    public void run() {
        // make http call to get the price
        prices.add(0);
        latch.countDown();
    }
}

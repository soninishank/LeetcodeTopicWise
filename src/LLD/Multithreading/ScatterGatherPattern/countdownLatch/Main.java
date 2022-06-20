package LLD.Multithreading.ScatterGatherPattern.countdownLatch;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    ExecutorService executorService = Executors.newFixedThreadPool(4);

    private Set<Integer> getPrices(int productId) throws InterruptedException {
        Set<Integer> integers = Collections.synchronizedSet(new HashSet<Integer>());
        CountDownLatch countDownLatch = new CountDownLatch(3);
        executorService.submit(new Task("url1", productId, integers, countDownLatch));
        executorService.submit(new Task("url2", productId, integers, countDownLatch));
        executorService.submit(new Task("url3", productId, integers, countDownLatch));

        countDownLatch.await(3, TimeUnit.SECONDS);// wait for countdown to zero or timeout whichever occurs first

        return integers;
    }

    public static void main(String[] args) {
    }


}

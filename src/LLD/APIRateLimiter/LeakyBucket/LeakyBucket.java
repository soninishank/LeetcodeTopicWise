package LLD.APIRateLimiter.LeakyBucket;

import LLD.APIRateLimiter.RateLimiter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LeakyBucket implements RateLimiter {

    BlockingQueue<Integer> blockingDeque;

    public LeakyBucket(int size) {
        this.blockingDeque = new ArrayBlockingQueue<>(size);
    }

    @Override
    public boolean grantAccess() {
        if (blockingDeque.remainingCapacity() > 0) {
            blockingDeque.add(1);
            return true;
        }
        return false;
    }
}

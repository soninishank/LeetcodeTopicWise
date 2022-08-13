package LLD.APIRateLimiter.TokenBucket;

import LLD.APIRateLimiter.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimiter {
    private final int bucketCapacity;
    private final int refillRate;
    private final AtomicInteger currentCapacity;
    private final AtomicLong lastUpdatedTime;

    public TokenBucket(int bucketCapacity, int refillRate) {
        this.bucketCapacity = bucketCapacity;
        this.refillRate = refillRate;
        currentCapacity = new AtomicInteger(bucketCapacity); // no of tokens initially is equal to the maximum capacity
        lastUpdatedTime = new AtomicLong(System.currentTimeMillis());// current time
    }

    @Override
    public boolean grantAccess() {
        refillBucket();// refill the tokens since the last call
        if (currentCapacity.get() > 0) {
            currentCapacity.decrementAndGet();
            return true;
        }
        return false; // request is throttled as bucket doesn't have enough tokens
    }

    void refillBucket() {
        long currentTime = System.currentTimeMillis();
        int additionalToken = (int) ((currentTime - lastUpdatedTime.get()) / 1000 * refillRate); // these many tokens accumulated since the last call - dividing by 1000 to convert in seconds
        int currCapacity = Math.min(currentCapacity.get() + additionalToken, bucketCapacity);// no of tokens should never exceed maximum capacity
        currentCapacity.getAndSet(currCapacity);
        lastUpdatedTime.getAndSet(currentTime);
    }
}

package LLD.APIRateLimiter.LeakyBucket;

import LLD.APIRateLimiter.LeakyBucket.LeakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer, LeakyBucket> bucketMap;

    public UserBucketCreator(int id) {
        this.bucketMap = new HashMap<>();
        bucketMap.put(id, new LeakyBucket(10));
    }

    void accessApplication(int id) {
        if (bucketMap.get(id).grantAccess()) {
            System.out.println(Thread.currentThread().getName() + " Able to access");
        } else {
            System.out.println(Thread.currentThread() + "Too many requests please try after some time");
        }
    }
}

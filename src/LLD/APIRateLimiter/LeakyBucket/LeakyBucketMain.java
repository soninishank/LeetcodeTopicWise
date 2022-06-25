package LLD.APIRateLimiter.LeakyBucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LeakyBucketMain {

    public static void main(String[] args) {
        int userId = 1;
        UserBucketCreator userBucketCreator = new UserBucketCreator(userId);
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for (int i = 0; i < 12; i++) {
            executorService.execute(() -> userBucketCreator.accessApplication(userId));
        }
        executorService.shutdown();
    }
}

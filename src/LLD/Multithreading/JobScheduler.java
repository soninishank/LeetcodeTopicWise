package LLD.Multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JobScheduler {
    private final BlockingQueue<Runnable> jobQueue;
    private final ThreadPoolExecutor threadPool;
    private final int poolSize;

    // Constructor
    public JobScheduler(int poolSize) {
        this.poolSize = poolSize;
        this.jobQueue = new LinkedBlockingQueue<>();
        this.threadPool = new ThreadPoolExecutor(
                poolSize, // Core pool size
                poolSize, // Maximum pool size
                60L, TimeUnit.SECONDS, // Keep-alive time for idle threads
                new LinkedBlockingQueue<>() // Work queue for the thread pool
        );
    }

    // Method to schedule a job
    public void schedule(Runnable job) {
        try {
            jobQueue.put(job); // Add job to the queue
            threadPool.execute(jobQueue.take()); // Dispatch job from the queue to a thread
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle interruption
        }
    }

    // Shutdown the scheduler
    public void shutdown() {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    // Main for demonstration
    public static void main(String[] args) {
        JobScheduler scheduler = new JobScheduler(5); // Create a scheduler with 5 threads

        // Schedule jobs
        for (int i = 0; i < 10; i++) {
            int jobId = i;
            scheduler.schedule(() -> {
                System.out.println("Executing Job " + jobId + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate job execution
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shutdown the scheduler
        scheduler.shutdown();
        System.out.println("All jobs completed. Scheduler shutting down.");
    }
}

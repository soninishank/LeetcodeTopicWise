package Coding;
import java.util.concurrent.*;
import java.util.*;

public class EventProcessor {
    // Map to hold queues for each key
    private final Map<String, BlockingQueue<String>> eventMap = new ConcurrentHashMap<>();
    private final ExecutorService executor;

    public EventProcessor(int kThreads) {
        // Thread pool with k threads
        this.executor = Executors.newFixedThreadPool(kThreads);
    }

    // Method to submit an event to the appropriate queue based on key
    public void submitEvent(String event, String key) {
        // Get or create a queue for this key
        eventMap.computeIfAbsent(key, k -> new LinkedBlockingQueue<>()).offer(event);
        // Process events for this key
        executor.submit(() -> processEventsForKey(key));
    }

    // Process events in order for a given key
    private void processEventsForKey(String key) {
        BlockingQueue<String> queue = eventMap.get(key);
        if (queue != null) {
            String event;
            // Process events until the queue is empty
            while ((event = queue.poll()) != null) {
                System.out.println("Processing event: " + event + " for key: " + key);
                // Simulate event processing delay
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Method to shut down the executor gracefully
    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public static void main(String[] args) {
        // Create an event processor with 3 threads
        EventProcessor processor = new EventProcessor(3);

        // Simulate events with different keys
        processor.submitEvent("e1", "k1");
        processor.submitEvent("e2", "k2");
        processor.submitEvent("e3", "k1");
        processor.submitEvent("e4", "k3");
        processor.submitEvent("e5", "k2");
        processor.submitEvent("e6", "k4");
        processor.submitEvent("e7", "k1");

        // Shutdown after all events are processed
        processor.shutdown();
    }
}

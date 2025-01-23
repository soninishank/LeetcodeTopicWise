package Coding.Amazon.LogicAndMaintainable;

import java.util.Comparator;
import java.util.concurrent.*;

// Implement an unbounded set where each entry has an expiration date and disappears once it has expired.
public class ExpiringSet<T> {
    private final ConcurrentHashMap<T, Long> map = new ConcurrentHashMap<>();
    private final PriorityBlockingQueue<T> queue = new PriorityBlockingQueue<>(
            11, Comparator.comparingLong(map::get));
    private final ScheduledExecutorService cleaner = Executors.newScheduledThreadPool(1); // single thread

    public ExpiringSet() {
        cleaner.scheduleAtFixedRate(() -> removeExpiredEntries(), 1, 1, TimeUnit.SECONDS);
    }

    public void add(T item, long ttlMillis) {
        long expirationTime = System.currentTimeMillis() + ttlMillis;
        // Remove expired items before adding the new item
        removeExpiredEntries();
        // Add the new item
        map.put(item, expirationTime);
        queue.offer(item);
    }

    // Remove expired entries (common function)
    private void removeExpiredEntries() {
        long now = System.currentTimeMillis();
        while (!queue.isEmpty() && map.get(queue.peek()) <= now) {
            T expiredItem = queue.poll();
            map.remove(expiredItem);
        }
    }

    public boolean contains(T item) {
        Long expirationTime = map.get(item);
        if (expirationTime == null || expirationTime <= System.currentTimeMillis()) {
            map.remove(item);
            queue.remove(item);
            return false;
        }
        return true;
    }

    public void remove(T item) {
        map.remove(item);
        queue.remove(item);
    }

    public int size() {
        return (int) map.entrySet().stream()
                .filter(entry -> entry.getValue() > System.currentTimeMillis())
                .count();
    }

    public void shutdown() {
        cleaner.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        ExpiringSet<String> set = new ExpiringSet<>();
        set.add("A", 2000); // Add "A" with TTL of 2 seconds
        set.add("B", 5000); // Add "B" with TTL of 5 seconds

        System.out.println(set.contains("A")); // true
        Thread.sleep(3000);
        System.out.println(set.contains("A")); // false
        System.out.println(set.contains("B")); // true
        set.shutdown();
    }
}

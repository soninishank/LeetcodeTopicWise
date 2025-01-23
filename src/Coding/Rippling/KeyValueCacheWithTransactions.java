package Coding.Rippling;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

// https://leetcode.com/discuss/interview-question/4985212/Rippling-or-PhoneScreen-or-KeyValue-Datastore/
public class KeyValueCacheWithTransactions {
    private static final String TOMBSTONE = "TOMBSTONE";

    private final Map<String, String> permanentCache;
    private final Stack<Map<String, String>> transactionStack;
    private boolean isTransactionActive;
    private final ReentrantLock lock;

    public KeyValueCacheWithTransactions() {
        this.permanentCache = new HashMap<>();
        this.transactionStack = new Stack<>();
        this.isTransactionActive = false;
        this.lock = new ReentrantLock();
    }

    public void set(String key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value cannot be null.");
        }
        lock.lock();
        try {
            if (isTransactionActive) {
                transactionStack.peek().put(key, value);
            } else {
                permanentCache.put(key, value);
            }
        } finally {
            lock.unlock();
        }
    }

    public String get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        lock.lock();
        try {
            String value = null;
            if (isTransactionActive) {
                for (int i = transactionStack.size() - 1; i >= 0;
                     i--) {
                    if (transactionStack.get(i).containsKey(key)) {
                        value = transactionStack.get(i).get(key);
                        break;
                    }
                }
            }
            if (value == null) {
                value = permanentCache.get(key);
            }
            if (value != null && !value.equals(TOMBSTONE)) {
                return value;
            } else {
                return null;
            }
        } finally {
            lock.unlock();
        }
    }

    public void delete(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        lock.lock();
        try {
            if (isTransactionActive) {
                transactionStack.peek().put(key, TOMBSTONE);
            } else {
                permanentCache.remove(key);
            }
        } finally {
            lock.unlock();
        }
    }

    public void begin() {
        lock.lock();
        try {
            isTransactionActive = true;
            transactionStack.push(new HashMap<>());
        } finally {
            lock.unlock();
        }
    }

    public void commit() {
        lock.lock();
        try {
            if (!isTransactionActive || transactionStack.isEmpty()) {
                throw new IllegalStateException("No active transaction to commit.");
            }

            Map<String, String> currentTransaction = transactionStack.pop();

            for (Map.Entry<String, String> entry : currentTransaction.entrySet()) {
                if (entry.getValue().equals(TOMBSTONE)) {
                    permanentCache.remove(entry.getKey());
                } else {
                    permanentCache.put(entry.getKey(), entry.getValue());
                }
            }

            if (transactionStack.isEmpty()) {
                isTransactionActive = false;
            }
        } finally {
            lock.unlock();
        }
    }

    public void rollback() {
        lock.lock();
        try {
            if (!isTransactionActive || transactionStack.isEmpty()) {
                throw new IllegalStateException("No active transaction to rollback.");
            }
            transactionStack.pop();
            if (transactionStack.isEmpty()) {
                isTransactionActive = false;
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        KeyValueCacheWithTransactions cache = new KeyValueCacheWithTransactions();

        cache.set("key1", "value1");
        cache.get("key1");

        cache.begin();
        cache.set("key1", "tempValue1");
        cache.set("key2", "tempValue2");
        cache.get("key1");
        cache.get("key2");

        cache.begin();
        cache.set("key1", "nestedValue1");
        cache.get("key1");
        cache.rollback();

        cache.get("key1");
        cache.commit();
        cache.get("key1");
        cache.get("key2");
    }
}
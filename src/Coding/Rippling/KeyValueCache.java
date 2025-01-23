package Coding.Rippling;

import java.util.HashMap;
import java.util.Map;

public class KeyValueCache {
    // Internal storage for the cache
    private final Map<String, String> permanentCache;

    // Constructor to initialize the cache
    public KeyValueCache() {
        this.permanentCache = new HashMap<>();
    }

    // Add or update a key-value pair in the cache
    public void set(String key, String value) {
        permanentCache.put(key, value);
        System.out.println("SET " + key + " -> " + value);
    }

    // Retrieve the value associated with a key
    public String get(String key) {
        String value = permanentCache.get(key);
        if (value != null) {
            System.out.println("GET " + key + " -> " + value);
            return value;
        } else {
            System.out.println("GET " + key + " -> NOT FOUND");
            return null;
        }
    }

    // Remove a key-value pair from the cache
    public void delete(String key) {
        if (permanentCache.containsKey(key)) {
            permanentCache.remove(key);
            System.out.println("DELETE " + key + " -> OK");
        } else {
            System.out.println("DELETE " + key + " -> NOT FOUND");
        }
    }

    public static void main(String[] args) {
        // Example usage
        KeyValueCache cache = new KeyValueCache();
        cache.set("key1", "value1");
        cache.get("key1");
        cache.delete("key1");
        cache.get("key1");
    }
}
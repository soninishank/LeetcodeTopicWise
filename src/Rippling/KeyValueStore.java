package Rippling;

import java.util.concurrent.ConcurrentHashMap;

public class KeyValueStore {
    private final ConcurrentHashMap<String, String> hashmap;
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    public KeyValueStore(ConcurrentHashMap<String, String> hashmap) {
        this.hashmap = new ConcurrentHashMap<>(INITIAL_CAPACITY, LOAD_FACTOR);
    }

    public String get(String key) {
        validateKey(key);
        return hashmap.get(key);
    }

    private void validateKey(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (key.trim().isEmpty()) {
            throw new IllegalArgumentException("Key cannot be empty");
        }
    }

    public void set(String key, String value) {
        validateKey(key);
        validateValue(value);
        hashmap.put(key, value);
    }

    private void validateValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
    }

    public boolean delete(String key) {
        validateKey(key);
        return hashmap.remove(key) != null;
    }

    public int size() {
        return hashmap.size();
    }

    public boolean containsKey(String key) {
        validateKey(key);
        return hashmap.containsKey(key);
    }

}



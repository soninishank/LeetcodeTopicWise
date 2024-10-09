package Coding;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class DatabaseSystem {
    private Map<String, Database> databases = new HashMap<>();

    public void createDatabase(String name) {
        if (databases.containsKey(name)) {
            throw new IllegalArgumentException("Database already exists");
        }
        databases.put(name, new Database());
    }

    public Database getDatabase(String name) {
        if (!databases.containsKey(name)) {
            throw new NoSuchElementException("Database not found");
        }
        return databases.get(name);
    }
}

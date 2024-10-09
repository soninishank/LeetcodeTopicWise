package Coding;

import java.util.*;

public class Database {
    private Map<String, Table> tables = new HashMap<>();

    public void createTable(String name) {
        if (tables.containsKey(name)) {
            throw new IllegalArgumentException("Table already exists");
        }
        tables.put(name, new Table(name));
    }

    public Table getTable(String name) {
        if (!tables.containsKey(name)) {
            throw new NoSuchElementException("Table not found");
        }
        return tables.get(name);
    }
}

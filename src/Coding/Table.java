package Coding;

import java.util.*;

public class Table {
    private String name;
    private List<Map<String, Object>> rows = new ArrayList<>();
    private Map<Integer, Map<String, Object>> index = new HashMap<>();
    private int autoIncrementId = 1;

    public Table(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void insert(String name, int age) {
        Map<String, Object> row = new HashMap<>();
        row.put("id", autoIncrementId++);
        row.put("name", name);
        row.put("age", age);
        rows.add(row);
        index.put((Integer) row.get("id"), row);
    }

    public void update(int id, String name, Integer age) {
        Map<String, Object> row = index.get(id);
        if (row != null) {
            if (name != null) row.put("name", name);
            if (age != null) row.put("age", age);
        }
    }

    public void delete(int id) {
        Map<String, Object> row = index.remove(id);
        if (row != null) {
            rows.remove(row);
        }
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }
}

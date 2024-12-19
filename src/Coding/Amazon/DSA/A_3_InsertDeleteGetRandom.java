package Coding.Amazon.DSA;

import java.util.*;

//Design a data structure that would support the following functions in constant time O(1)
//1. insert() - insert an item if not present already
//2. delete() - delete an item if present
//3. search() - return the index of the item if present
//4. getRandom() - return a random element from present in data structure
public class A_3_InsertDeleteGetRandom {
    // List to store elements
    private List<Integer> list;
    // Map to store an element and its index in the list
    private Map<Integer, Integer> map;
    // Random object to generate random indices
    private Random random;

    public A_3_InsertDeleteGetRandom() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    // Inserts an item if not present already
    public boolean insert(int value) {
        if (map.containsKey(value)) {
            return false; // Already present
        }
        // Add to the list and map
        list.add(value);
        map.put(value, list.size() - 1);
        return true;
    }

    // Deletes an item if present
    public boolean delete(int value) {
        if (!map.containsKey(value)) {
            return false; // Not present
        }
        // Get the index of the element to be removed
        int index = map.get(value);
        // Get the last element in the list
        int lastElement = list.get(list.size() - 1);

        // Swap the element to be removed with the last element
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove the last element from the list and the map
        list.remove(list.size() - 1);
        map.remove(value);

        return true;
    }

    // Returns the index of the item if present
    public int search(int value) {
        return map.getOrDefault(value, -1);
    }

    // Returns a random element
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        A_3_InsertDeleteGetRandom rds = new A_3_InsertDeleteGetRandom();

        System.out.println(rds.insert(10)); // true
        System.out.println(rds.insert(20)); // true
        System.out.println(rds.insert(30)); // true
        System.out.println(rds.insert(10)); // false

        System.out.println(rds.search(20)); // Index of 20
        System.out.println(rds.search(40)); // -1

        System.out.println(rds.delete(20)); // true
        System.out.println(rds.delete(40)); // false

        System.out.println(rds.getRandom()); // Random element from the structure
    }
}

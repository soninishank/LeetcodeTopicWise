package Coding.PriorityQueue;

import java.util.HashMap;
import java.util.PriorityQueue;

// (o1, o2) -> hashMap.get(o2) - hashMap.get(o1)
// sorting by size - largest to smallest, but we are not polling
// https://leetcode.com/problems/sort-characters-by-frequency/
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> hashMap.get(o2) - hashMap.get(o1));// maxPQ - largest to smallest
        // Iterating over hashmap keyset because priority queue you don't know exact ordering
        for (char c : hashMap.keySet()) {
            pq.add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!pq.isEmpty()) {
            Character poll = pq.poll();
            Integer count = hashMap.get(poll);
            while (count > 0) {
                stringBuilder.append(poll);
                count--;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String tree = new SortCharactersByFrequency().frequencySort("cccaaa");
        System.out.println(tree);
    }
}

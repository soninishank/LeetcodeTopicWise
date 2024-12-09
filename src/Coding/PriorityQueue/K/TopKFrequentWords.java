package Coding.PriorityQueue.K;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        // Build hashmap
        for (String word : words) {
            hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
        }

        // PriorityQueue with custom comparator
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            int freq1 = hashmap.get(o1);
            int freq2 = hashmap.get(o2);

            if (freq1 == freq2) {
                return o2.compareTo(o1); // Lexicographical order (reverse for min-heap behavior)
            }
            return freq1 - freq2; // Compare by frequency
        });

        // Add elements to the PriorityQueue
        for (String word : hashmap.keySet()) {
            pq.add(word);
            if (pq.size() > k) {
                pq.poll(); // Remove the least frequent element
            }
        }
        // Build the result list from the PriorityQueue
        List<String> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(0, pq.poll()); // Add elements in reverse order
        }

        return list;
    }

    public static void main(String[] args) {
        String[] str = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> list1 = new TopKFrequentWords().topKFrequent(str, 2);
        System.out.println(list1);
    }
}

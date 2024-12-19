package Coding.PriorityQueue.K;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

// when you call poll() on a PriorityQueue (min-heap), it does the following:
// 1. Removes the smallest element from the heap.
// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        // 1. Build hashmap
        for (String word : words) {
            hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
        }

        // 2. PriorityQueue with custom comparator
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            int freq1 = hashmap.get(o1);
            int freq2 = hashmap.get(o2);

            if (freq1 == freq2) {
                return o2.compareTo(o1); // Lexicographical order (reverse for min-heap behavior)
            }
            return freq1 - freq2; // Compare by frequency
        });

        // 3. Add elements to the PriorityQueue
        for (String word : hashmap.keySet()) {
            pq.add(word);
            if (pq.size() > k) {
                pq.poll(); // Remove the least frequent element
            }
        }
        // 4. Build the result list from the PriorityQueue
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

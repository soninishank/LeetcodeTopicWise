package Coding.Amazon.ProblemSolving;

import java.util.*;

public class TopKSearchWords {
    public static List<String> getTopKSearchTerms(List<String> terms, int k) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (String term : terms) {
            // Convert to lowercase for case-insensitivity
            String lowerCaseTerm = term.toLowerCase();
            hashMap.put(lowerCaseTerm, hashMap.getOrDefault(lowerCaseTerm, 0) + 1);
        }

        // Create a PriorityQueue (min-heap) to keep track of top k terms
        PriorityQueue<String> minHeap = new PriorityQueue<>((o1, o2) -> {
            int freq1 = hashMap.get(o1);
            int freq2 = hashMap.get(o2);

            if (freq1 == freq2) {
                return o2.compareTo(o1); // Lexicographical order (reverse for min-heap behavior)
            }
            return freq1 - freq2; // Compare by frequency
        });

        // Add all entries to the heap, maintaining only the top k elements
        for (String word : hashMap.keySet()) {
            minHeap.add(word);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }
        // 4. Build the result list from the PriorityQueue
        List<String> list = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            list.add(0, minHeap.poll()); // Add elements in reverse order
        }

        return list;
    }

    public static void main(String[] args) {
        List<String> terms = Arrays.asList("sofa", "tv", "rug", "desk", "sofa", "tv", "rug", "tv", "sofa", "tv", "Sofa", "sofa");
        int k = 2;

        List<String> topKTerms = getTopKSearchTerms(terms, k);
        System.out.println(topKTerms); // Output: [tv, sofa]
    }
}

package Coding.PriorityQueue.K;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (hashMap.get(o1) == hashMap.get(o2)) {
                    return o2.compareTo(o1);
                }
                return hashMap.get(o1) - hashMap.get(o2);
            }
        });
        for (String word : hashMap.keySet()) {
            priorityQueue.add(word);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()) {
            String poll = priorityQueue.poll();
            list.add(0, poll);
        }
        return list;
    }

    public static void main(String[] args) {
        String[] str = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> list1 = new TopKFrequentWords().topKFrequent(str, 2);
        System.out.println(list1);
    }
}

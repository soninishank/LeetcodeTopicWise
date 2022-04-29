package Coding.PriorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        System.out.println(hashMap);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> hashMap.get(o1) - hashMap.get(o2)); // descending
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()) {
            int value = priorityQueue.poll();
            System.out.println(value);
        }
        return null;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ints = new TopKFrequentElements().topKFrequent(arr, k);
        System.out.println(Arrays.toString(ints));
    }
}

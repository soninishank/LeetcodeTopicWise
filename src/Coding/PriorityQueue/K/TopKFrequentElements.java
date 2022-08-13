package Coding.PriorityQueue.K;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

// largest repetitive elements return
// remove smaller counts
//https://leetcode.com/problems/top-k-frequent-elements/
// Blind-75
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> hashMap.get(o1) - hashMap.get(o2)); // ascending
        for (int num : hashMap.keySet()) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] result = new int[priorityQueue.size()];
        int i = result.length - 1;
        // Here
        while (priorityQueue.size() > 0) {
            result[i] = priorityQueue.poll();
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ints = new TopKFrequentElements().topKFrequent(arr, k);
        System.out.println(Arrays.toString(ints));
    }
}

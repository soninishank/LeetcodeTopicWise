package Coding.PriorityQueue.K;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
// Do use quick select
public class KthLargestElementInAnArray {
    // O(N lg K) running time + O(K) memory
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

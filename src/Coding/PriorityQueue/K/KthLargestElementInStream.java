package Coding.PriorityQueue.K;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargestElementInStream {
    PriorityQueue<Integer> pq;
    int k = 0;

    public KthLargestElementInStream(int k, int[] nums) {
        pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        this.k = k;
    }

    public int add(int val) {
        pq.add(val);
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

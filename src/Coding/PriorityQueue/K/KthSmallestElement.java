package Coding.PriorityQueue.K;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
public class KthSmallestElement {
    public int kthSmallest(int[] arr, int l, int r, int k) {
        //Your code here
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = l; i < r; i++) {
            priorityQueue.add(arr[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            minPQ.add(nums[i]);
            if (minPQ.size() > k) {
                minPQ.poll();
            }
        }
        int[] result = new int[minPQ.size()];
        int i = 0;
        Iterator<Integer> pq = minPQ.iterator();
        while (pq.hasNext()) {
            result[i] = pq.next();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int K = 3;
        new KthSmallestElement().kthSmallest(arr, 0, arr.length, K);
    }
}

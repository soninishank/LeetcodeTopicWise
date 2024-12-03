package Coding.SlidingWindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// 480. Sliding Window Median
// https://leetcode.com/problems/sliding-window-median/

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new double[0];

        // Min heap for the right half and max heap for the left half
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // Add to the appropriate heap
            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }

            // Balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            // Remove the element that is sliding out
            // Once we have processed at least k elements, calculate the median
            if (i >= k - 1) {
                if (k % 2 == 1) {
                    // Odd window size, median is the top of maxHeap
                    result[i - k + 1] = maxHeap.peek();
                } else {
                    // Even window size, median is the average of the tops of maxHeap and minHeap
                    result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
                }

                // Remove the element sliding out of the window
                int toRemove = nums[i - k + 1];
                if (maxHeap.contains(toRemove)) {
                    maxHeap.remove(toRemove);
                } else {
                    minHeap.remove(toRemove);
                }

                // Balance the heaps after removal
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMedian solution = new SlidingWindowMedian();
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(solution.medianSlidingWindow(nums1, k1))); // Output: [1.0, -1.0, -1.0, 3.0, 5.0, 6.0]

        int[] nums2 = {1, 2, 3, 4, 2, 3, 1, 4, 2};
        int k2 = 3;
        System.out.println(Arrays.toString(solution.medianSlidingWindow(nums2, k2))); // Output: [2.0, 3.0, 3.0, 3.0, 2.0, 3.0, 2.0]
    }
}

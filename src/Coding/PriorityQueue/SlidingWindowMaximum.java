package Coding.PriorityQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sliding-window-maximum/discuss/65936/My-Java-Solution-Using-PriorityQueue
// 239. Sliding Window Maximum
// https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindowTLE(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        result[0] = priorityQueue.peek();
        for (int i = k; i < nums.length; i++) {
            priorityQueue.remove(nums[i - k]);
            priorityQueue.add(nums[i]);
            result[i - k + 1] = priorityQueue.peek();
        }
        return result;
    }

    private int[] maxSlidingWindow(int[] nums, int k) {
        // Works like queue - FIFO
        Deque<Integer> deque = new LinkedList<>();// store by index
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // removing the start candidates
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // if the last element is smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = new SlidingWindowMaximum().maxSlidingWindowTLE(arr, 3);
        System.out.println(Arrays.toString(ints));
        int[] array = new SlidingWindowMaximum().maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(array));
    }


}

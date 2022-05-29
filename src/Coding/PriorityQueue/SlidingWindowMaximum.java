package Coding.PriorityQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sliding-window-maximum/discuss/65936/My-Java-Solution-Using-PriorityQueue
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
        // peek - first element which is inserted
        // peek means looking at first element of deque and peeklast means looking at last element of the deque
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll(); // remove the first element
            }
            // For storing the max we will do
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                result[index] = nums[deque.peek()];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = new SlidingWindowMaximum().maxSlidingWindowTLE(arr, 3);
        System.out.println(Arrays.toString(ints));
        int[] array = new SlidingWindowMaximum().maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(array));
    }


}

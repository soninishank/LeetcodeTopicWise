package Coding.Stack;

import java.util.Stack;

// https://leetcode.com/problems/132-pattern/
// 456. 132 Pattern
public class Pattern {
    // [3,1,4,2]
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>(); // only used to store the first largest element - 4
        int secondLargest = Integer.MIN_VALUE; // it will store only secondLargest which is 2
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < secondLargest) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                secondLargest = stack.peek();
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}

package Coding.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

// circular next greater element to right
// https://leetcode.com/problems/next-greater-element-ii/
// just use modulo to handle indexing case
public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] ints = new NextGreaterElementII().nextGreaterElements(nums);
        System.out.println(Arrays.toString(ints));
    }


    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        int length = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek() % length] <= nums[i % length]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i % length] = -1;
            } else {
                result[i % length] = nums[stack.peek() % length];
            }
            stack.push(i);
        }
        return result;
    }
}

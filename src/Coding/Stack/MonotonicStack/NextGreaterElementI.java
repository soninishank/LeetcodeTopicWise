package Coding.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/
// same logic as Daily Temperatures
// firstly create next greater element , store keys and values in hashmap
public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        int[] ints = new NextGreaterElementI().nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[stack.peek()] <= nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                hashMap.put(nums2[i], -1);
            } else {
                hashMap.put(nums2[i], nums2[stack.peek()]);
            }
            stack.push(i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = hashMap.containsKey(nums1[i]) ? hashMap.get(nums1[i]) : -1;
        }
        return result;
    }
}

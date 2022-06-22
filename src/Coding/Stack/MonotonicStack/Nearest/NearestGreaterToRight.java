package Coding.Stack.MonotonicStack.Nearest;

import java.util.Arrays;
import java.util.Stack;

// next larger element
// https://youtu.be/NXOOYYwpbg4
// https://leetcode.com/problems/next-greater-element-i/
public class NearestGreaterToRight {
    private int[] nearestGreaterToRight(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 15, 6, 2, 10}; // -1,-1,3,-1
        int[] nearestGreaterToRight = new NearestGreaterToRight().nearestGreaterToRight(arr);
        System.out.println(Arrays.toString(nearestGreaterToRight));
    }
}

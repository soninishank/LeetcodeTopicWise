package Coding.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

// Next greater element to right
// https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
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
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = new DailyTemperatures().dailyTemperatures(arr);
        System.out.println(Arrays.toString(ints));
    }
}

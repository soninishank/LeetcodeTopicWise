package Stack.MonotonicStack;

import java.util.Stack;

// TODO - review
// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        int i = new LargestRectangleInHistogram().largestRectangleArea(arr);
        System.out.println(i);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] nearestSmallerToLeft = nearestSmallerToLeft(heights); // need to store only index - if stack is empty store -1
        int[] nearestSmallerToRight = nearest_smaller_to_right(heights); //need to store only index  - if stack is empty store height.length
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int width = nearestSmallerToRight[i] - nearestSmallerToLeft[i] - 1;
            int largestValue = heights[i] * width;
            max = Math.max(max, largestValue);
        }
        return max;
    }

    private int[] nearest_smaller_to_right(int[] arr) {
        int[] result = new int[arr.length];
        Stack<StackIndex> stack = new Stack<>();
        for (int i = result.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().currentValue >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = arr.length;
            } else {
                result[i] = stack.peek().index;
            }
            stack.push(new StackIndex(arr[i], i));
        }
        return result;
    }

    private int[] nearestSmallerToLeft(int[] arr) {
        int[] result = new int[arr.length];
        Stack<StackIndex> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek().currentValue >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek().index;
            }
            stack.push(new StackIndex(arr[i], i));
        }
        return result;
    }
}

package Coding.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

// NearestGreaterToLeft
// indexing is from 1 in result
// https://leetcode.com/problems/online-stock-span/
// TODO - important
public class OnlineStockSpan {

    public static void main(String[] args) {
        int[] arr = {28, 14, 28, 35, 46, 53, 66}; // nearest greater to left
        int[] ints = new OnlineStockSpan().nearestGreaterElementIndexToLeft(arr);
        System.out.println(Arrays.toString(ints));
    }

    private int[] nearestGreaterElementIndexToLeft(int[] arr) {
        int[] result = new int[arr.length];
        Stack<StackIndex> stack = new Stack<>();
        for (int i = 0; i < result.length; i++) {
            while (!stack.isEmpty() && stack.peek().currentValue <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = i + 1;
            } else {
                result[i] = i - stack.peek().index;
            }
            stack.push(new StackIndex(arr[i], i));
        }
        return result;
    }

}


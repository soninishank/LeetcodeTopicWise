package Coding.Stack.MonotonicStack.Nearest;

import java.util.Arrays;
import java.util.Stack;

// https://youtu.be/T5s96ynzArg
// https://www.callicoder.com/nearest-greater-to-left/
public class NearestGreaterToLeft {
    private int[] nearestGreaterToLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 15, 6, 2, 10}; //-1, 9, -1, 15, 6, 15
        int[] nearestGreaterLeft = new NearestGreaterToLeft().nearestGreaterToLeft(arr);
        System.out.println(Arrays.toString(nearestGreaterLeft));
    }

}

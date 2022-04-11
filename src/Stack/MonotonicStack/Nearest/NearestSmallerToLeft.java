package Stack.MonotonicStack.Nearest;

import java.util.Arrays;
import java.util.Stack;

// https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
// https://youtu.be/85LWui3FlVk
public class NearestSmallerToLeft {

    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 2, 5};
        int[] ints = new NearestSmallerToLeft().nearestSmallerToLeft(arr);
        System.out.println(Arrays.toString(ints));
    }

    private int[] nearestSmallerToLeft(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
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
}

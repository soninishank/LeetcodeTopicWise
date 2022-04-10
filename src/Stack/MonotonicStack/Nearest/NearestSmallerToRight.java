package Stack.MonotonicStack.Nearest;

import java.util.Arrays;
import java.util.Stack;

// https://www.procoding.org/nearest-smaller-to-right/
// https://youtu.be/nc1AYFyvOR4
public class NearestSmallerToRight {

    private int[] nearest_smaller_to_right(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = result.length - 1; i >= 0; i--) {
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


    public static void main(String[] args) {
        int[] arr = {6, 4, 10, 2, 5}; // 4,2,2,-1,-1
        int[] ints = new NearestSmallerToRight().nearest_smaller_to_right(arr);
        System.out.println(Arrays.toString(ints));
    }


}

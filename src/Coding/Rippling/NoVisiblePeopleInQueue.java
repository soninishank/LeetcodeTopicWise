package Coding.Rippling;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/number-of-visible-people-in-a-queue/
// Number of Visible People in a Queue
public class NoVisiblePeopleInQueue {
    public int[] canSeePersonsCount(int[] heights) {
        int length = heights.length;
        int result[] = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            int current_height = heights[i];
            int visible_persons = 0;

            while (!stack.isEmpty() && current_height > heights[stack.peek()]) {
                visible_persons += 1;
                stack.pop();
            }
            // This is the extra condition - means the biggest element that is present in
            // the stack
            // we can still see him
            // [10,6,8,5,11,9]
            // without below logic -> [2,0,1,0,1,0]
            // with below logic -> [3,1,2,1,1,0]
            if (!stack.isEmpty()) {
                visible_persons += 1;
            }
            stack.push(i);
            result[i] = visible_persons;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {10, 6, 8, 5, 11, 9};
        int[] ints = new NoVisiblePeopleInQueue().canSeePersonsCount(heights);
        System.out.println(Arrays.toString(ints));
    }
}

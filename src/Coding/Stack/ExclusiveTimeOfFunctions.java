package Coding.Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/exclusive-time-of-functions/
// "1:start:2" -> 1 is the function name , start is action , 2 is timestamp
public class ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n]; // To store exclusive time for each function
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of active functions
        int prevTime = 0; // Tracks the previous timestamp

        for (String log : logs) {
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            String action = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (action.equals("start")) {
                // If there is an active function on the stack, add the elapsed time to it
                if (!stack.isEmpty()) {
                    result[stack.peek()] += timestamp - prevTime;
                }
                // Push the new function onto the stack
                stack.push(functionId);
                prevTime = timestamp;
            } else { // action is "end"
                // Pop the function from the stack and calculate its exclusive time
                result[stack.pop()] += timestamp - prevTime + 1;
                prevTime = timestamp + 1; // Update prevTime to the next timestamp
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        int[] ints = new ExclusiveTimeOfFunctions().exclusiveTime(n, logs);
        System.out.println(Arrays.toString(ints));
    }
}

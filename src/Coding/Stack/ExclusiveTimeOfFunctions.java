package Coding.Stack;

import java.util.*;

// https://leetcode.com/problems/exclusive-time-of-functions/
// 636. Exclusive Time of Functions
// "1:start:2" -> 1 is the function name, start is action, 2 is timestamp
public class ExclusiveTimeOfFunctions {

    public Map<Integer, Integer> exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        // int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            hashMap.put(i, 0);
        }
        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("End log without matching start: " + log);
                }
                Log top = stack.pop();
                int duration = log.time - top.time + 1;
                // result[top.id] += duration // Add the time difference (inclusive) to the current

                hashMap.put(top.id, hashMap.get(top.id) + duration);
                // function
                if (!stack.isEmpty()) {
                    int parentId = stack.peek().id;
                    //result[parentId] -= duration; // It will make the result as [-4,4] , toh ye karta hai bich me jo aya hai uska subtraction lata hai
                    hashMap.put(parentId, hashMap.get(parentId) - duration);
                }
            }
        }
        if (!stack.isEmpty()) {
            throw new IllegalStateException("Stack is not empty at the end of logs processing.");
        }
        return hashMap;
    }

    public static class Log {
        public int id;
        public boolean isStart;
        public int time;

        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        Map<Integer, Integer> ints = new ExclusiveTimeOfFunctions().exclusiveTime(n, logs);
        System.out.println((ints));
    }
}

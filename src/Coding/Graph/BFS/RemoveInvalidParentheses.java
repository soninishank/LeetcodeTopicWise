package Coding.Graph.BFS;

import java.util.*;

// https://leetcode.com/problems/remove-invalid-parentheses/
// Using BFS
// Breadth First search
public class RemoveInvalidParentheses {

    // Function to remove the minimum number of invalid parentheses
    // Space Complexity is - O(2^n.n)
    // Time Complexity is - O(2^n.n)
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        // Using a queue for BFS
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        boolean found = false;

        // Start BFS
        while (!queue.isEmpty()) {
            String current = queue.poll();

            // Check if the current string is valid
            if (isValid(current)) {
                result.add(current);
                found = true;
            }
            // Once we find a valid string, we do not generate further invalid ones
            if (found) continue;

            // Generate all possible states by removing a parenthesis
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')')
                    continue;

                String next = current.substring(0, i) + current.substring(i + 1); // skipping one index every time
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return result;
    }

    // Function to check if the string has valid parentheses
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                // If count goes negative, parentheses are not balanced
                if (count < 0) return false;
            }
        }
        return count == 0; // A valid string should have equal opening and closing parentheses
    }

    public static void main(String[] args) {
        String s = "(a)())()";
        List<String> strings = new RemoveInvalidParentheses().removeInvalidParentheses(s);
        System.out.println(strings);
    }
}

// ()())
// )()()
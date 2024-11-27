package Coding.Stack.Parentheses;

import java.util.Stack;

// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != c) {
                    count++;
                }
            }
        }
        count += stack.size();
        return count;
    }

    // same as - minimum remove to make parentheses valid
    public int minAddToMakeValid2(String s) {
        int count = 0;
        int open = 0;
        // Step 1: Left-to-Right Pass
        // remove closed parentheses if there is no open parenthesis
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                } else {
                    count++;
                }
            }
        }
        // Step 2: Right-to-Left Pass
        // remove open parentheses if there is no closed parenthesis
        int closed = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ')') {
                closed++;
            } else if (ch == '(') {
                if (closed > 0) {
                    closed--;
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "))";
        int i = new MinimumAddToMakeParenthesesValid().minAddToMakeValid(s);
        System.out.println(i);
    }
}

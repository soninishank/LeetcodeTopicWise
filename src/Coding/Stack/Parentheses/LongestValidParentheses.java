package Coding.Stack.Parentheses;

import java.util.Stack;

// TODO - https://leetcode.com/problems/longest-valid-parentheses/
// Check if the string scanned so far is valid.
// Find the length of the longest valid string.
// In order to do so, we start by pushing -1−1 onto the stack. For every \text{‘(’}‘(’ encountered, we push its index
// onto the stack.
// For every \text{‘)’}‘)’ encountered, we pop the topmost element. Then, the length of the currently encountered
// valid string of parentheses will be the difference between the current element's index and the top element of the
// stack.
// If, while popping the element, the stack becomes empty, we will push the current element's index onto the stack.
// In this way, we can continue to calculate the length of the valid substrings and return the length of the longest
// valid string at the end.
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxAns = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }


    public static void main(String[] args) {
        int i = new LongestValidParentheses().longestValidParentheses("()"); // to understand the use case of -1
        System.out.println(i);
    }
}

package Coding.Stack.Parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// we are storing indexes
// TODO : META
public class MinimumRemoveToMakeValidParentheses {

    // TC - O(N)
    // SC - O(N)
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    list.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(i)) {
                continue;
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    // Approach 2
    // Iterate left to right -> Eliminate extra closed parenthesis
    // Iterate right to left -> Eliminate extra open parenthesis
    // https://youtu.be/NNxaYz0nrk0?t=944
    public String minRemoveToMakeValid1(String s) {
        int open = 0;
        StringBuilder builder = new StringBuilder();
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
                    continue;
                }
            }
            builder.append(ch);
        }
        // Step 2: Right-to-Left Pass
        // remove open parentheses if there is no closed parenthesis
        s = builder.toString(); // we need to use the same builder that we used above
        int closed = 0;
        StringBuilder finalBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ')') {
                closed++;
            } else if (ch == '(') {
                if (closed > 0) {
                    closed--;
                } else {
                    continue;
                }
            }
            finalBuilder.append(ch);
        }
        return finalBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        String s = "))(()";
        String s1 = new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s);
        System.out.println(s1);

        String s11 = new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid1(s);
        System.out.println(s11);

    }

}

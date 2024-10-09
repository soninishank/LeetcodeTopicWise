package Coding.Stack.Parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// we are storing indexes
// TODO : META
public class MinimumRemoveToMakeValidParentheses {
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

    public String minRemoveToMakeValid1(String s) {
        int open = 0;
        StringBuilder builder = new StringBuilder();
        // Step 1: Left-to-Right Pass
        // skip closing door if there is no open door
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (open > 0) {
                    open--;
                    builder.append(ch);
                }
            } else if (ch == '(') {
                open++;
                builder.append(ch);
            } else {
                builder.append(ch);
            }
        }
        // Step 2: Right-to-Left Pass
        // If there are any openDoor which are unmatched -> so we remove them 
        StringBuilder result = new StringBuilder();
        for (int i = builder.length() - 1; i >= 0; i--) {
            char ch = builder.charAt(i);
            if (ch == '(' && open > 0) {
                open--;
            } else {
                result.append(ch);
            }
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        String s = "))(()";
        String s1 = new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s);
        System.out.println(s1);

        String s11 = new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid1(s);
        System.out.println(s11);

    }

}

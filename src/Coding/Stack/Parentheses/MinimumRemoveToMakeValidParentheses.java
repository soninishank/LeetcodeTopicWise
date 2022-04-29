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


    public static void main(String[] args) {
        String s = "))(()";
        String s1 = new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s);
        System.out.println(s1);
    }

}

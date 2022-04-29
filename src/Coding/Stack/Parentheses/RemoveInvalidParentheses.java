package Coding.Stack.Parentheses;

import java.util.*;

public class RemoveInvalidParentheses {
    List<String> resultList = new ArrayList<>();
    HashSet<String> visitedSet = new HashSet<>();

    private List<String> removeInvalidParentheses(String s) {
        int invalidParenthesesToRemove = invalidParentheses(s);
        solution(s, invalidParenthesesToRemove);
        if (resultList.isEmpty()) {
            return Collections.emptyList();
        }
        return resultList;
    }

    private void solution(String str, int minimumAllowed) {
        if (visitedSet.contains(str)) {
            return;
        }
        visitedSet.add(str);
        if (minimumAllowed == 0) {
            if (invalidParentheses(str) == 0) {
                resultList.add(str);
            }
        }
        for (int i = 1; i < str.length(); i++) {
            String s = str.substring(0, i) + str.substring(i + 1);
            solution(s, minimumAllowed - 1);
        }
    }

    private int invalidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    stack.push(')');
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(')');
                }
            }
        }
        return stack.size();
    }


    public static void main(String[] args) {
        String s = ")(";
        List<String> strings = new RemoveInvalidParentheses().removeInvalidParentheses(s);
        System.out.println(strings);
    }
}

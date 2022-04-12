package Stack.Parentheses;

import java.util.Stack;

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

    public static void main(String[] args) {
        String s = "))";
        int i = new MinimumAddToMakeParenthesesValid().minAddToMakeValid(s);
        System.out.println(i);
    }
}

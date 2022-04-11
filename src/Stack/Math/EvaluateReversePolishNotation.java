package Stack.Math;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
// Reverse polish - operators precede their operands.
public class EvaluateReversePolishNotation {
    Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if (token.equals("+")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second + first);
            } else if (token.equals("-")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second - first);
            } else if (token.equals("*")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second * first);
            } else if (token.equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = new EvaluateReversePolishNotation().evalRPN(str);
        System.out.println(i);
    }
}

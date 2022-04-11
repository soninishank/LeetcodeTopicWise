package Stack.Math;

import java.util.Stack;

// 1.If the current operator is multiplication (*) or division (/), then the expression is evaluated
// irrespective of the next operation. This is because in the given set of operations (+,-,*,/),
// the * and / operations have the highest precedence and therefore must be evaluated first
// 2. If the current operation is addition (+) or subtraction (-), then the expression is evaluated based on
// the precedence of the next operation.
// No Parentheses in this question - basic calculator ii
// Only signs -> -,+,/,*
// Order of operations is
// 1.multiplication and division
// 2.addition and subtraction
// https://leetcode.com/problems/basic-calculator/
public class BasicCalculatorII {
    private int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char prevOp = '+'; // TODO Very important
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else if ("+-*/".indexOf(c) >= 0) {
                evaluate(stack, prevOp, num); // just dump the existing num value
                prevOp = c;// set this operation as new value
                num = 0;
            }
        }
        evaluate(stack, prevOp, num);
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private void evaluate(Stack<Integer> stack, char operation, int num) {
        // we can do addition and subtraction later on also
        if (operation == '+') {
            stack.push(num);
            return;
        } else if (operation == '-') {
            stack.push(-num);
            return;
        } else if (operation == '*') {
            stack.push(stack.pop() * num);
            return;
        } else if (operation == '/') {
            stack.push(stack.pop() / num);
            return;
        }
    }

    public static void main(String[] args) {
        String s = "3+5 / 2"; // first divide then addition
        int calculate = new BasicCalculatorII().calculate(s);
        System.out.println(calculate);
    }
}

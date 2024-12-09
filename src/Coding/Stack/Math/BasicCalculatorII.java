package Coding.Stack.Math;

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
    // TC - O(n)
    // SC - O(n)
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char prevOperator = '+'; // TODO Very important
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                evaluate(stack, prevOperator, num); // just dump the existing num value
                prevOperator = c;// set this operation as new value
                num = 0;
            }
        }
        evaluate(stack, prevOperator, num); // again for the last number
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private void evaluate(Stack<Integer> stack, char prevOperator, int num) {
        // we can do addition and subtraction later on also
        if (prevOperator == '+') {
            stack.push(num);
        } else if (prevOperator == '-') {
            stack.push(-num);
        } else if (prevOperator == '*') {
            stack.push(stack.pop() * num);
        } else if (prevOperator == '/') {
            stack.push(stack.pop() / num);
        }
    }

    public static void main(String[] args) {
        String s = "3+5 / 2"; // first divide then addition
        int calculate = new BasicCalculatorII().calculate(s);
        System.out.println(calculate);
    }
}

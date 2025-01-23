package Coding.Amazon.ProblemSolving;

import java.util.Stack;

public class PrefixExpressionEvaluator {

    // Function to evaluate prefix expressions
    public double evaluatePrefix(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        // Process the tokens from right to left
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            // If the token is an operator
            if (isOperator(token)) {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                stack.push(applyOperator(token, operand1, operand2));
            } else {
                // If the token is a number, push it to the stack
                stack.push(Double.parseDouble(token));
            }
        }
        // The final result will be the last item in the stack
        return stack.pop();
    }

    // Helper function to check if a token is an operator
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Helper function to apply an operator to two operands
    private static double applyOperator(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        PrefixExpressionEvaluator prefixExpressionEvaluator = new PrefixExpressionEvaluator();
        // Test cases
        String expression1 = "+ 4 2";
        System.out.println(prefixExpressionEvaluator.evaluatePrefix(expression1)); // Output: 6

        String expression2 = "+ * 2 3 4";
        System.out.println(prefixExpressionEvaluator.evaluatePrefix(expression2)); // Output: 10

        String expression3 = "* + 2 3 4";
        System.out.println(prefixExpressionEvaluator.evaluatePrefix(expression3)); // Output: 20

        String expression4 = "+ / 4 2 / 6 2";
        System.out.println(prefixExpressionEvaluator.evaluatePrefix(expression4)); // Output: 5
    }
}

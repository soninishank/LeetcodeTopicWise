package Coding.Amazon.DSA;

import java.util.Stack;

public class _1_PrefixEvaluator {

    public static int evaluatePrefix(String expression) {
        // Split the expression into tokens
        String[] tokens = expression.trim().split("\\s+");
        Stack<Integer> stack = new Stack<>();

        // Iterate over tokens in reverse order
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isNumeric(token)) {
                // Push numbers onto the stack
                stack.push(Integer.parseInt(token));
            } else {
                // Pop two operands from the stack
                int operand1 = stack.pop(); // Left operand
                int operand2 = stack.pop(); // Right operand

                // Apply the operator and push the result
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2); // Integer division
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }

        // The final result will be the only item in the stack
        return stack.pop();
    }

    // Helper method to check if a string is numeric
    private static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String expression = "- + 5 3 6"; // Example expression
        int result = evaluatePrefix(expression);
        System.out.println("Result: " + result); // Output: 4
    }
}

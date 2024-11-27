package Coding.Math;

import java.util.HashMap;

// https://leetcode.com/problems/fraction-to-recurring-decimal/
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Step 1: Handle the sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert to long to handle edge cases like Integer.MIN_VALUE
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Step 2: Append the integer part
        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0) {
            return result.toString(); // No fractional part
        }

        // Step 3: Append the decimal point
        result.append(".");

        // Step 4: Simulate long division for the fractional part
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                // Repeating part found
                int start = remainderMap.get(remainder);
                result.insert(start, "(");
                result.append(")");
                break;
            }

            // Store the current remainder and its position
            remainderMap.put(remainder, result.length());

            // Update remainder and calculate the next digit - its a basic math

            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = new FractionToRecurringDecimal().fractionToDecimal(4, 3);
        System.out.println(s);
    }
}

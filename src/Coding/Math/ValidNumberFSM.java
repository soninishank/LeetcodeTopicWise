package Coding.Math;

// https://leetcode.com/problems/valid-number/
// 65. Valid Number
public class ValidNumberFSM {
    public boolean isNumber(String s) {
        // Trim whitespace
        s = s.trim();
        boolean hasNum = false; // To ensure there is at least one digit
        boolean hasDot = false; // To handle decimals
        boolean hasExp = false; // To handle scientific notation (e/E)

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                hasNum = true;
            } else if (c == '.') {
                // Dot is valid only if there's no previous dot or exponent
                if (hasDot || hasExp) {
                    return false;
                }
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                // Exponent is valid only if there's no previous exponent and there was a number before it
                if (hasExp || !hasNum) return false;
                hasExp = true;
                hasNum = false; // Reset for the number after 'e'
            } else if (c == '+' || c == '-') {
                // Sign is valid only at the beginning or immediately after 'e'
                if (i > 0)
                    return false;
                if (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } else {
                // Invalid character
                return false;
            }
        }

        // Return true only if there's at least one number and no hanging 'e' or '.'
        return hasNum;
    }

    public static void main(String[] args) {
        ValidNumberFSM solution = new ValidNumberFSM();

        // Test cases
        System.out.println(solution.isNumber("0"));            // true
        System.out.println(solution.isNumber("e"));           // false
        System.out.println(solution.isNumber("."));           // false
        System.out.println(solution.isNumber("2"));           // true
        System.out.println(solution.isNumber("0089"));        // true
        System.out.println(solution.isNumber("-0.1"));        // true
        System.out.println(solution.isNumber("+3.14"));       // true
        System.out.println(solution.isNumber("4."));          // true
        System.out.println(solution.isNumber("-.9"));         // true
        System.out.println(solution.isNumber("2e10"));        // true
        System.out.println(solution.isNumber("-90E3"));       // true
        System.out.println(solution.isNumber("3e+7"));        // true
        System.out.println(solution.isNumber("+6e-1"));       // true
        System.out.println(solution.isNumber("53.5e93"));     // true
        System.out.println(solution.isNumber("-123.456e789"));// true
        System.out.println(solution.isNumber("abc"));         // false
        System.out.println(solution.isNumber("1a"));          // false
        System.out.println(solution.isNumber("1e"));          // false
        System.out.println(solution.isNumber("e3"));          // false
        System.out.println(solution.isNumber("99e2.5"));      // false
        System.out.println(solution.isNumber("--6"));         // false
        System.out.println(solution.isNumber("-+3"));         // false
        System.out.println(solution.isNumber("95a54e53"));    // false
    }
}

package Meta;

// https://leetcode.com/problems/string-to-integer-atoi/
//  String to Integer (atoi)
public class ASCIIToInteger_44 {
    public int myAtoi(String s) {
        // Step 1: Handle empty string
        if (s == null || s.length() == 0) {
            return 0;
        }
        // Step 2: Ignore leading whitespace
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // Step 3: Check for '+' or '-' sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        // Step 4: Convert digits to integer
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 5: Check for overflow/underflow
            // we are just simple writing this
            // result * 10 + digit -> result = -digit/10 -> This is exactly the same as 7. reverseInteger condition
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }
        // Step 6: Return a final result with sign
        return result * sign;
    }

    public static void main(String[] args) {
        ASCIIToInteger_44 atoi = new ASCIIToInteger_44();

        // Test cases
        System.out.println(atoi.myAtoi("42"));              // Output: 42
        System.out.println(atoi.myAtoi("   -042"));         // Output: -42
        System.out.println(atoi.myAtoi("1337c0d3"));        // Output: 1337
        System.out.println(atoi.myAtoi("0-1"));             // Output: 0
        System.out.println(atoi.myAtoi("words and 987"));   // Output: 0
        System.out.println(atoi.myAtoi("-91283472332"));    // Output: -2147483648 (Integer.MIN_VALUE)
        System.out.println(atoi.myAtoi("91283472332"));     // Output: 2147483647 (Integer.MAX_VALUE)
        System.out.println(atoi.myAtoi("+"));               //  Output: 0
        System.out.println(atoi.myAtoi("-"));               //  Output: 0
        System.out.println(atoi.myAtoi(" "));               //  Output: 0
        System.out.println(atoi.myAtoi("000000042"));       //  Output: 42
    }
}

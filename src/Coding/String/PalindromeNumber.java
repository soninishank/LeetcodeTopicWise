package Coding.String;

// https://leetcode.com/problems/palindrome-number/
// 9. Palindrome Number
// It's like basic reverse integer
// Note: If the number is lower than zero return false because -121 reverse will be 121-
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // If the number is negative or if it's a multiple of 10 (except 0), it's not a palindrome
        if (x < 0) {
            return false;
        }

        // This is checking if the number is not 10,100, 1000 because if you reverse them it will be 01,001,0001 that is wrong
        // Also it is checking that x != 0 because x = 0 is a valid palindrome
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        int original = x;
        int reversed = 0;

        while (x > 0) {
            // Get the last digit of x
            int lastDigit = x % 10;
            // Append the last digit to the reversed number
            reversed = reversed * 10 + lastDigit;
            // Remove the last digit from x
            x /= 10;
        }

        // Check if the original number is equal to the reversed number
        return original == reversed;
    }

    public static void main(String[] args) {
        boolean palindrome = new PalindromeNumber().isPalindrome(10);
        System.out.println(palindrome);
    }
}

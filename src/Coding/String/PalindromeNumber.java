package Coding.String;

// https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int originalValue = x;
        int rev = 0;
        while (x != 0) {
            int temp = x % 10;
            rev = rev * 10 + temp;
            x = x / 10;
        }
        if (rev == originalValue) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean palindrome = new PalindromeNumber().isPalindrome(10);
        System.out.println(palindrome);
    }
}

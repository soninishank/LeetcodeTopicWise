package Coding.String;

// https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return checkIsValid(s, low, high - 1) || checkIsValid(s, low + 1, high);
            }
        }
        return true;
    }

    private boolean checkIsValid(String str, int low, int high) {
        while (low <= high) {
            if (str.charAt(low) == str.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isValid = new ValidPalindromeII().validPalindrome("aba");
        System.out.println(isValid);
    }
}

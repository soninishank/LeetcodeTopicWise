package Coding.String;

// https://leetcode.com/problems/valid-palindrome-ii/
// 680. Valid Palindrome II
// TC : O(N) -> only for loop is used
// SC : O(1)
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return checkIsValid(s, low + 1, high) || checkIsValid(s, low, high - 1);
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

package Coding.String;

// https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += checkPalindrome(s, i, i);
            count += checkPalindrome(s, i, i + 1);
        }
        return count;
    }

    private int checkPalindrome(String s, int low, int high) {
        int count = 0;
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abc";
        int i = new PalindromicSubstrings().countSubstrings(s);
        System.out.println(i);
    }
}

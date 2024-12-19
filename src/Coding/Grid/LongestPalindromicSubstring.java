package Coding.Grid;

import java.util.Arrays;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        String result = "";
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < s.length(); j++, i++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1;
                } else if (gap > 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
                if (dp[i][j] == 1) {
                    String subStr = s.substring(i, j + 1);
                    if (subStr.length() > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return result;
    }

    public static void main(String[] args) {
        String babad = new LongestPalindromicSubstring().longestPalindrome("babad");
        System.out.println(babad);
    }
}

// This is the optimized approach 
// Its very easy 
// Time Complexity - O(N^2) - Outer for loop and inner while loop
// Space Complexity - O(1)
class Solution {
    int finalDifference = 0;
    int start = 0;

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            findLength(s, i, i); // odd kind of palindrome
            findLength(s, i, i + 1); // even kind of palindrome
        }
        return s.substring(start, start + finalDifference);
    }

    private void findLength(String str, int low, int high) {
        while (low >= 0 && high < str.length()) {
            if (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            } else {
                break;
            }
        }
        int diff = high - low - 1;
        if (diff > finalDifference) {
            finalDifference = diff;
            start = low + 1; // because low can be -1;
        }
    }
}

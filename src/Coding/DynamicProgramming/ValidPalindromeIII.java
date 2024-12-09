package Coding.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-palindrome-iii/
// 1216. Valid Palindrome III
public class ValidPalindromeIII {
    public boolean isValidPalindrome(String s, int k) {
        return isKPalindromeHelper(s, 0, s.length() - 1, k);
    }

    private boolean isKPalindromeHelper(String s, int left, int right, int k) {
        // If we've used up our allowed removals, we can't proceed -> this should be the first step
        if (k < 0) {
            return false;
        }
        // If the left index meets or surpasses the right, we have a valid palindrome
        // Input string: "abcba"
        // left = 2, right = 2 because both 'a' and 'b' matched
        if (left >= right) {
            return true;
        }

        if (s.charAt(left) == s.charAt(right)) {
            // Characters match, move inward
            return isKPalindromeHelper(s, left + 1, right - 1, k);
        } else {
            // Characters don't match, we have two options: remove left or remove right
            return isKPalindromeHelper(s, left + 1, right, k - 1) || isKPalindromeHelper(s, left, right - 1, k - 1);
        }
    }

    public boolean isValidPalindromeMemoized(String s, int k) {
        Map<String, Boolean> memo = new HashMap<>();
        return checkPalindromeMemo(s, 0, s.length() - 1, k, memo);
    }

    private boolean checkPalindromeMemo(String s, int left, int right, int k, Map<String, Boolean> memo) {
        // If we've used up our allowed removals, we can't proceed
        if (k < 0) {
            return false;
        }
        // If the left index meets or surpasses the right, we have a valid palindrome
        if (left >= right) {
            return true;
        }
        String key = left + "," + right + "," + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (s.charAt(left) == s.charAt(right)) {
            // Characters match, move inward
            boolean result = checkPalindromeMemo(s, left + 1, right - 1, k, memo);
            memo.put(key, result); // Store the result in the memo map
            return result;
        } else {
            // Characters don't match, we have two options: remove left or remove right
            boolean result = checkPalindromeMemo(s, left + 1, right, k - 1, memo) || checkPalindromeMemo(s, left, right - 1, k - 1, memo);
            memo.put(key, result); // Store the result in the memo map
            return result;
        }
    }
}

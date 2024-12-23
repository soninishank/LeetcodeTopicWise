package Meta;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/discuss/interview-question/372459/facebook-phone-screen-palindromic-subsequences
// https://leetcode.com/problems/palindromic-substrings/ - instead of count print the result
// "aabbaab" ->
// "a", "a" , "a" , "a" , "b","b","b", "aa", "aa", "bb", "aabbaa", "baab", "abba"
public class FindAllSubstringsInAPalindrome_4 {

    public List<String> findPalindromes(String s) {
        List<String> palindromes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i, palindromes);     // Odd-length palindromes
            expandAroundCenter(s, i, i + 1, palindromes); // Even-length palindromes
        }
        return palindromes;
    }

    private void expandAroundCenter(String str, int low, int high, List<String> palindromes) {
        while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
            palindromes.add(str.substring(low, high + 1)); // Add the palindrome substring
            low--;
            high++;
        }
    }

    public static void main(String[] args) {
        String s = "aaa";
        List<String> palindromes = new FindAllSubstringsInAPalindrome_4().findPalindromes(s);
        System.out.println(palindromes);
    }
}


//        List<String> palindromicSubstrings = new ArrayList<>();
//
//        // Helper function to check if a substring is a palindrome
//        private boolean isPalindrome(String str) {
//            int left = 0, right = str.length() - 1;
//            while (left < right) {
//                if (str.charAt(left) != str.charAt(right)) {
//                    return false;
//                }
//                left++;
//                right--;
//            }
//            return true;
//        }
//
//        public List<String> findPalindromicSubstrings(String s) {
//            // Iterate over all substrings
//            for (int i = 0; i < s.length(); i++) {
//                for (int j = i; j < s.length(); j++) {
//                    String substring = s.substring(i, j + 1);
//                    if (isPalindrome(substring)) {
//                        palindromicSubstrings.add(substring);
//                    }
//                }
//            }
//            return palindromicSubstrings;
//        }
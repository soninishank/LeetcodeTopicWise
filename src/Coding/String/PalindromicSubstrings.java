package Coding.String;

// https://leetcode.com/problems/palindromic-substrings/
// We choose all possible centers for potential palindromes:
//Every single character in the string is a center for possible odd-length palindromes
//Every pair of consecutive characters in the string is a center for possible even-length palindromes.
//For every center, we can expand around it as long as we get palindromes (i.e., the first and last characters should match)
public class PalindromicSubstrings {
    // TC - O(N^2) - outer while loop and inner for loop
    // SC - O(1)
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += checkPalindrome(s, i, i); // TODO : You are passing the same index
            count += checkPalindrome(s, i, i + 1); // TODO : You are passing the i and i+1
        }
        return count;
    }

    // we are passing complete string
    // and just checking through index
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
        String s = "babab";
        int i = new PalindromicSubstrings().countSubstrings(s);
        System.out.println(i);
    }
}

// total 9
// b a b a b  - individual characters
// bab
// aba
// bab
// babab

package Coding.DynamicProgramming;

// https://leetcode.com/problems/regular-expression-matching/
public class RegularExpressionsMatching {
    public boolean isMatch(String s, String p) {
        // Base case: if the pattern is empty, check if the string is also empty
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // Check if the first characters match (or if pattern has a '.')
        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        // If there is a '*' as the second character in the pattern
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // Two options: ignore "character*" or use "character*" to match current char in s
            boolean a = isMatch(s, p.substring(2));
            boolean b = (firstMatch && isMatch(s.substring(1), p));
            return a || b;
        } else {
            // If no '*' is involved, just check firstMatch and move to the next characters
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        String s = "ab", p = ".*";
        boolean match = new RegularExpressionsMatching().isMatch(s, p);
        System.out.println(match);
    }
}

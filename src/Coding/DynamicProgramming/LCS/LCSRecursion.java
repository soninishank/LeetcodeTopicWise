package Coding.DynamicProgramming.LCS;

public class LCSRecursion {
    public int longestCommonSubsequenceRecursion(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        return LCSUsingRecursion(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    private int LCSUsingRecursion(String text1, String text2, int length1, int length2) {
        if (length1 < 0 || length2 < 0) {
            return 0;
        }
        if (text1.charAt(length1) == text2.charAt(length2)) {
            return 1 + LCSUsingRecursion(text1, text2, length1 - 1, length2 - 1);
        } else {
            int first = LCSUsingRecursion(text1, text2, length1 - 1, length2);
            int second = LCSUsingRecursion(text1, text2, length1, length2 - 1);
            return Math.max(first, second);
        }
    }

    public static void main(String[] args) {
        int i = new LCSRecursion().longestCommonSubsequenceRecursion("abcde", "ace");
        System.out.println(i);
    }
}

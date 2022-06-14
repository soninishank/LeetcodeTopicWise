package Coding.DynamicProgramming.LCSPatterns;

// https://leetcode.com/problems/longest-palindromic-subsequence/
// LPS : LCS (Reverse of Input String ,Input String)
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        return findLCS(s, reverse, s.length(), reverse.length());
    }

    private int findLCS(String str, String reverse, int n, int m) {
        int[][] mat = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                } else if (str.charAt(i - 1) == reverse.charAt(j - 1)) {
                    mat[i][j] = 1 + mat[i - 1][j - 1];
                } else {
                    int v1 = mat[i][j - 1];
                    int v2 = mat[i - 1][j];
                    mat[i][j] = Math.max(v1, v2);
                }
            }
        }
        return mat[n][m];
    }

    public static void main(String[] args) {
        int result = new LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab");
        System.out.println(result);
    }
}

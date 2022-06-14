package Coding.DynamicProgramming.LCS;

// https://leetcode.com/problems/longest-common-subsequence/
public class LCSUsingDP {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        return usingTopDown(text1, text2, text1.length(), text2.length());
    }

    private int usingTopDown(String text1, String text2, int n, int m) {
        int[][] mat = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
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
}

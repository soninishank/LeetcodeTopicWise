package Coding.DynamicProgramming.LCS;

import java.util.Arrays;

public class LCSMemoization {
    public int longestCommonSubsequenceMemoization(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return usingMemoization(text1, text2, text1.length(), text2.length(), dp);
    }

    private int usingMemoization(String text1, String text2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            return dp[n][m] = 1 + usingMemoization(text1, text2, n - 1, m - 1, dp);
        } else {
            int v1 = usingMemoization(text1, text2, n, m - 1, dp);
            int v2 = usingMemoization(text1, text2, n - 1, m, dp);
            return dp[n][m] = Math.max(v1, v2);
        }
    }

    public static void main(String[] args) {
        int i = new LCSMemoization().longestCommonSubsequenceMemoization("a", "a");
        System.out.println(i);
    }
}

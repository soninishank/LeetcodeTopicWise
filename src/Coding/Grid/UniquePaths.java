package Coding.Grid;

// https://leetcode.com/problems/unique-paths/
// Row & col = 1 -> only 1 value
// otherwise - left side and upper side
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j]; // you need to add both number - above one and left one
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

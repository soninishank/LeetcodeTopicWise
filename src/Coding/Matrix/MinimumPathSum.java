package Coding.Matrix;

// https://leetcode.com/problems/minimum-path-sum/
// Three steps
// 1.Fill index grid[0,0] to dp[0,0]
// 2.Fill first row
// 3.Fill first column
// 4.Fill inner row and columns - current grid + Coding.Math.min(left side,vertical side)

// Time Complexity (TC): O(m * n)
// Space Complexity (SC): O(m * n)
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0]; // TODO  need to remember
        // Fill first row , column change
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        // Fill first column, row change
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        // fill other rows and column now
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

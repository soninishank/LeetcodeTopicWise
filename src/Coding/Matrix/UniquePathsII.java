package Coding.Matrix;

// obstacle - good question
// https://leetcode.com/problems/unique-paths-ii/

public class UniquePathsII {
    private static final int OBSTACLE = 1; // Variable to represent obstacle

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the start or end point is an obstacle, no paths are possible.
        if (obstacleGrid[0][0] == OBSTACLE || obstacleGrid[m - 1][n - 1] == OBSTACLE) {
            return 0;
        }

        // DP array to store the number of ways to reach each cell.
        int[][] dp = new int[m][n];

        // Initialize the starting point.
        dp[0][0] = 1;

        // Fill the first row.
        for (int i = 1; i < n; i++) {
            //  Not an obstacle and last column is also 1 than only we will reach this position - very important
            if (obstacleGrid[0][i] != OBSTACLE && dp[0][i - 1] == 1) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0; // obstacle
            }
        }

        // Fill the first column.
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != OBSTACLE && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        // Fill the rest with the DP array.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != OBSTACLE) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0; // There's an obstacle here.
                }
            }
        }
        // The bottom-right corner will contain the number of unique paths.
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        int[][] str = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int i = new UniquePathsII().uniquePathsWithObstacles(str);
        System.out.println(i);
    }

}

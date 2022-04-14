package DynamicProgramming.Grid;

import java.util.Arrays;

// obstacle
// https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        // it means we can't start
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        // Filling first row
        for (int i = 1; i < col; i++) {
            // obstacle
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
            } // not an obstacle and last column is also 1 - very important
            else if (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) {
                obstacleGrid[0][i] = 1;
            }
        }
        // Filling first column
        for (int i = 1; i < row; i++) {
            // obstacle
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            }// not an obstacle and last column is also 1
            else if (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) {
                obstacleGrid[i][0] = 1;
            }
        }
        // filling remaining rows
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else // obstacle
                {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(obstacleGrid));
        return obstacleGrid[row - 1][col - 1];
    }


    public static void main(String[] args) {
        int[][] str = {{0, 0}, {1, 1}, {0, 0}};
        int i = new UniquePathsII().uniquePathsWithObstacles(str);
        System.out.println(i);
    }

}

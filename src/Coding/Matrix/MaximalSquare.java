package Coding.Matrix;

import java.util.Arrays;

// https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int largest = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                    largest = Math.max(largest, dp[i][j]);
                }
            }
        }
        System.out.println(largest);
        System.out.println(Arrays.deepToString(dp));
        return largest * largest;
    }

    public static void main(String[] args) {
        char[][] ch = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int i = new MaximalSquare().maximalSquare(ch);
        System.out.println(i);
    }
}

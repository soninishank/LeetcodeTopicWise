package Coding.Matrix;

import java.util.Arrays;

// code is same as https://leetcode.com/problems/spiral-matrix/
// just add count = 1 and increment in each for loop
// https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int direction = 0; // 0 means left to right , 1 mean top to down , 2 mean right to left, 3 mean down to up
        int count = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            if (direction == 0) {
                for (int i = colBegin; i <= colEnd; i++) {
                    matrix[rowBegin][i] = count++; // First Row - row is same , col change
                }
                rowBegin++; // shift the position
            } else if (direction == 1) {
                for (int i = rowBegin; i <= rowEnd; i++) {
                    matrix[i][colEnd] = count++;// last col - col is same , row change
                }
                colEnd--;// move column to left
            } else if (direction == 2) {
                for (int i = colEnd; i >= colBegin; i--) {
                    matrix[rowEnd][i] = count++; // last row - row is same , col change
                }
                rowEnd--;
            } else if (direction == 3) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    matrix[i][colBegin] = count++; // first column - col is same , row is changing
                }
                colBegin++;
            }
            direction = (direction + 1) % 4;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = new SpiralMatrixII().generateMatrix(3);
        System.out.println(Arrays.deepToString(ints));
    }
}

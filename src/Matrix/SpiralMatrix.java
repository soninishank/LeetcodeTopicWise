package Matrix;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return result;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int direction = 0; // 0 means left to right , 1 mean top to down , 2 mean right to left, 3 mean down to up
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            if (direction == 0) {
                for (int i = colBegin; i <= colEnd; i++) {
                    result.add(matrix[rowBegin][i]); // First Row - row is same , col change
                }
                rowBegin++; // shift the position
            } else if (direction == 1) {
                for (int i = rowBegin; i <= rowEnd; i++) {
                    result.add(matrix[i][colEnd]);// last col - col is same , row change
                }
                colEnd--;// move column to left
            } else if (direction == 2) {
                for (int i = colEnd; i >= colBegin; i--) {
                    result.add(matrix[rowEnd][i]); // last row - row is same , col change
                }
                rowEnd--;
            } else if (direction == 3) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][colBegin]); // first column - col is same , row is changing
                }
                colBegin++;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = new SpiralMatrix().spiralOrder(matrix);
        System.out.println(list);
    }
}

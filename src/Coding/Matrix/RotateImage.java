package Coding.Matrix;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-image/
// clockwise - First row - last column
//   -> reverse then swap
// anticlockwise - last column - first row
// -> swap then reverse
public class RotateImage {

    // Reverse then swap
    // 1.Coding.Matrix level reverse
    // 2. row to col or vice versa you can say
    public void rotateClockwise(int[][] matrix) {
        reverse(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) { // j = i+1 , to not used already used col
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    void reverse(int[][] matrix) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int[] temp = matrix[low];
            matrix[low] = matrix[high];
            matrix[high] = temp;
            low++;
            high--;
        }
    }

    private void rotateAntiClockwise(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) { // j = i+1 , to not used already used col
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        reverse(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // new RotateImage().rotateClockwise(mat);
        new RotateImage().rotateAntiClockwise(mat);
    }

}

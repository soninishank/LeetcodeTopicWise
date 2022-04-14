package Matrix;

// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        // Traversing first row - row constant - col change
        for (int i = 0; i < colLength; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
            }
        }
        // Traversing first column - column constant - row change
        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
            }
        }

        // Travere other rows and col
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                if (matrix[i][j] == 0) { // If it's zero
                    matrix[i][0] = 0; // make first col zero
                    matrix[0][j] = 0; // make first row zero
                }
            }
        }

        // Now make other rows & col zero
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) { // If it's zero
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow) {
            for (int i = 0; i < colLength; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstCol) {
            for (int j = 0; j < rowLength; j++) {
                matrix[j][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new SetMatrixZeros().setZeroes(arr);
    }
}

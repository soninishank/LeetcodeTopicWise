package Meta;

// https://leetcode.com/discuss/interview-question/1985371/facebookmeta-e4-swe-phone-screening-2-coding-questions
public class PrintMatrixDiagonally {

    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Matrix is empty!");
            return;
        }
        int row = 0, col = 0;
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        while (row < rowCount && col < colCount) {
            printDiagonal(matrix, row, col);
            // If we reach the last column, move to the next row
            if (col == colCount - 1) {
                row++;
            } else {
                col++;
            }
        }
    }

    public static void printDiagonal(int[][] matrix, int row, int col) {
        // Traverse diagonally downwards
        while (row < matrix.length && col >= 0) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        printMatrix(matrix);
    }
}

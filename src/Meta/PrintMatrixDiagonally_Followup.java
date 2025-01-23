package Meta;

// Assume the matrix is saved in 1D row
public class PrintMatrixDiagonally_Followup {
    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Matrix is empty!");
            return;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        for (int col = 0; col < colCount; col++) {
            printDiagonal(matrix, 0, col);
        }

        // If you want to print last column ones - this is only used to print the last column ones
        // (1, 3) → 8, 11
        //(2, 3) → 12
        for (int row = 1; row < rowCount; row++) {
            printDiagonal(matrix, row, colCount - 1);
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

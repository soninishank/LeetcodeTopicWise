package Coding.Design;

// Design Tic-Tac-Toe
public class TicTacToe {
    int[][] matrix;
    int totalWinsRequired;

    public TicTacToe(int n) {
        matrix = new int[n][n];
        totalWinsRequired = n;
    }

    public int move(int row, int col, int player) {
        matrix[row][col] = player;
        if (checkWinningCondition(row, col, player)) {
            return player;
        }
        return 0;
    }

    boolean checkWinningCondition(int row, int col, int player) {
        boolean rowSignal = true;
        boolean colSignal = true;
        boolean diagonalSignal = true;
        boolean antiDiagonalSignal = true;

        // checking each row - horizontal
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] != player) {
                rowSignal = false;
                break;
            }
        }
        // checking each column - vertical
        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] != player) {
                colSignal = false;
                break;
            }
        }
        //check Diagonal - rowIndex = colIndex
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != player) {
                diagonalSignal = false;
                break;
            }
        }
        // check AntiDiagonal - difference between rowIndex & colIndex is same - start from top right
        for (int m = 0; m < matrix.length; m++) {
            if (matrix[m][matrix.length - m - 1] != player) {
                antiDiagonalSignal = false;
            }
        }
        return rowSignal || colSignal || antiDiagonalSignal || diagonalSignal;
    }
}

package Coding.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=xFv_Hl4B83A
// They are under attack - same row,same column , same diagonal
// in each row and column , we only have one queen will be placed
// the 2nd result will be the mirror image of first result
public class NQueens {

    private List<List<String>> resultBoard = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return resultBoard;
        }
        // Create a board
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        backtrack(matrix, 0, resultBoard);
        return resultBoard;
    }

    private void backtrack(char[][] matrix, int rowIndex, List<List<String>> resultBoard) {
        if (rowIndex == matrix.length) {
            resultBoard.add(build(matrix));
            return;
        }
        for (int col = 0; col < matrix.length; col++) {
            matrix[rowIndex][col] = 'Q';// place a queen
            if (isValidPosition(matrix, rowIndex, col)) {
                backtrack(matrix, rowIndex + 1, resultBoard);// i will go to next index if everything is good
            }
            matrix[rowIndex][col] = '.';// remove or backtrack
        }
    }

    private List<String> build(char[][] matrix) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            path.add(new String(matrix[i]));
        }
        return path;
    }

    private boolean isValidPosition(char[][] matrix, int rowIndex, int colIndex) {
        // check all cols
        for (int i = 0; i < rowIndex; i++) {
            if (matrix[i][colIndex] == 'Q') {
                return false;
            }
        }
        //check 45 degree
        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < matrix.length; i--, j++) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
        }
        //check 135
        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(4);
    }
}

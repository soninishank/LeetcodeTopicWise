package Coding.Backtracking;

import java.util.Arrays;

// // Each block is of size 3 - 3 rows & 3 cols
//    // starting row no. are -> 0,3,6 - Horizontally
//    // starting col No are -> 0,3,6 - vertically
//    // rowNo = 5 , colNo = 7
//    // startRowNoBlock = 3 * (5/3) = 3 * 1 = 3  - always same
//    // startColNoBlock = 3 * (7/3) = 3 * 3 = 6  - always same
//    // startRowNoBlock + (i/3) -> i = 0 -> 3 + 0 -> 3
//    //                         -> i = 1 -> 3 + 0 -> 3
//    //                         -> i = 2 -> 3 + 0 -> 3
//    //                         -> i = 3 -> 3 + 1 -> 4 -> the row gets changed
//    //                         -> i = 4 -> 3 + 1 -> 4
//    // startColNoBlock = 6 + (i % 3) = 6 + (0 % 3 ) = 6
//    //                 = 6 + (i % 3) = 6 + (1 % 3)  = 7
//    //                 = 6 + (i % 3) = 6 + (2 % 3 ) = 8
//    //                 = 6 + (i % 3) = 6 + (3 % 3 ) = 6 - repeat the same column
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        doSolve(board);
        System.out.println(Arrays.deepToString(board));
    }

    private boolean doSolve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                // fill char from 1 to 9
                for (char num = '1'; num <= '9'; num++) {
                    if (isValidBoard(board, i, j, num)) {
                        board[i][j] = num;
                        if (doSolve(board)) {
                            return true;
                        } else {
                            board[i][j] = '.';// unchoose
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValidBoard(char[][] board, int row, int col, char newCharacter) {
        int startRowNoBlock = 3 * (row / 3);
        int startColNoBlock = 3 * (col / 3);
        for (int i = 0; i < 9; i++) {
            // check all rows
            if (board[i][col] == newCharacter) {
                return false;
            }// check all columns
            if (board[row][i] == newCharacter) {
                return false;
            }
            // check 3 * 3 block
            if (board[startRowNoBlock + (i / 3)][startColNoBlock + (i % 3)] == newCharacter) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new SudokuSolver().solveSudoku(board);

    }
}

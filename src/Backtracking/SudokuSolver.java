//package Backtracking;
//
//public class SudokuSolver {
//    public boolean solveSudoku(char[][] board) {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (board[i][j] == '.') {
//                    for (char c = '1'; c <= '9'; c++) {
//                        if (isValid(i, j, c, board)) {
//                            board[i][j] = c;
//                            if (solveSudoku(board)) {
//                                return true;
//                            } else {
//                                board[i][j] = 'c';
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private boolean isValid(int row, int col, char c, char[][] board) {
//
//    }
//
//    public static void main(String[] args) {
//        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        new SudokuSolver().solveSudoku(board);
//    }
//}

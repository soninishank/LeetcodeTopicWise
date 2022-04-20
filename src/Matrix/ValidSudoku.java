package Matrix;

import java.util.HashSet;

// https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {

    HashSet<String> rowSet = new HashSet<>();
    HashSet<String> colSet = new HashSet<>();
    HashSet<String> BoardSet = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    String row = board[i][j] + " " + i;
                    String col = board[i][j] + " " + j;
                    String insideBoard = board[i][j] + " " + i / 3 + " " + j / 3;
                    if (!rowSet.add(row) || !colSet.add(col) || !BoardSet.add(insideBoard)) {
                        System.out.println(row);
                        System.out.println(col);
                        System.out.println(insideBoard);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean validSudoku = new ValidSudoku().isValidSudoku(board);
        System.out.println(validSudoku);
    }
}

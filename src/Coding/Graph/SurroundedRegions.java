package Coding.Graph;

import java.util.Arrays;

// check all surrounded regions with value 0 - apply DFS and apply newColor -'E'
// again traverse grid -surroundedColor to X and newColor to 0
// https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int totalRows = board.length - 1;
        int totalCols = board[0].length - 1;
        // Mark all those cells which are at boundary and if there any connected cells
        char surroundedColor = 'O';
        char newColor = 'E';
        for (int i = 0; i <= totalRows; i++) {
            for (int j = 0; j <= totalCols; j++) {
                if ((i == 0 || j == 0 || i == totalRows || j == totalCols)) {
                    if (board[i][j] == surroundedColor) {
                        applyDFS(i, j, board, surroundedColor, newColor);
                    }
                }
            }
        }
        for (int i = 0; i <= totalRows; i++) {
            for (int j = 0; j <= totalCols; j++) {
                if (board[i][j] == surroundedColor) {
                    board[i][j] = 'X';
                } else if (board[i][j] == newColor) {
                    board[i][j] = surroundedColor;
                }
            }
        }
    }

    private void applyDFS(int i, int j, char[][] board, char surroundedColor, char newColor) {
        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != surroundedColor) return;
        board[i][j] = newColor;
        applyDFS(i + 1, j, board, surroundedColor, newColor);
        applyDFS(i - 1, j, board, surroundedColor, newColor);
        applyDFS(i, j + 1, board, surroundedColor, newColor);
        applyDFS(i, j - 1, board, surroundedColor, newColor);
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'X', 'O', 'O'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'X', 'X'}};
        new SurroundedRegions().solve(board);
    }
}

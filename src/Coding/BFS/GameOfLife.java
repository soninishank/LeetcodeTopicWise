package Coding.BFS;


import java.util.HashMap;

// Follow up - how to do without extra space
// https://leetcode.com/problems/game-of-life/
public class GameOfLife {
    int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

    public void gameOfLife(int[][] board) {
        int totalRows = board.length;
        int totalCols = board[0].length;
        HashMap<Key, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                int aliveNeighbours = aliveNeighbours(board, i, j, totalRows, totalCols);
                // cell live
                if (board[i][j] == 1) {
                    //alive neighbours < 2 - underpopulation and overpopulation
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                        hashMap.put(new Key(i, j), 0);
                    } else {
                        hashMap.put(new Key(i, j), 1);
                    }
                }
                // cell is dead but alive neighbours = 3, then cell becomes alive
                else if (board[i][j] == 0 && aliveNeighbours == 3) {
                    hashMap.put(new Key(i, j), 1);
                }
            }
        }
        for (Key key : hashMap.keySet()) {
            board[key.rowNo][key.colNo] = hashMap.get(key);
        }
    }

    private int aliveNeighbours(int[][] board, int currentRow, int currentCol, int totalRows, int totalCols) {
        int alive = 0;
        for (int[] arr : dir) {
            int x = arr[0] + currentRow;
            int y = arr[1] + currentCol;
            // check for out of bound
            if (x >= 0 && y >= 0 && x <= totalRows - 1 && y <= totalCols - 1 && board[x][y] == 1) {
                alive++;
            }
        }
        return alive;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new GameOfLife().gameOfLife(arr);
    }

    class Key {
        int rowNo;
        int colNo;

        public Key(int rowNo, int colNo) {
            this.rowNo = rowNo;
            this.colNo = colNo;
        }
    }
}

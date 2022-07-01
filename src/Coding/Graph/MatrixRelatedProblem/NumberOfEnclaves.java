package Coding.Graph.MatrixRelatedProblem;

// https://leetcode.com/problems/number-of-enclaves/
// similar like surrounded regions concept - concept of boundary
// just need to return the count
// Time complexity : O(M * N)
// Space complexity : O(M * N) -> recursion stack
public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        // Firstly make all the boundary & its neighbouring cells to zero
        // 1. Mark all those cells which are at boundary and if there are any connected cells - handling 1st use case
        int surroundedColor = 1;
        int newColor = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // only boundaries
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
                    if (grid[i][j] == surroundedColor) {
                        markDifferentColor(grid, i, j, surroundedColor, newColor);
                    }
                }
            }
        }
        // 2. Now count all the 1's which are surrounded by 0
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == surroundedColor) {
                    count++;
                }
            }
        }
        return count;
    }


    private void markDifferentColor(int[][] grid, int row, int col, int surroundedColor, int newColor) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1) {
            return;
        }
        if (grid[row][col] == surroundedColor) {
            grid[row][col] = newColor;
            markDifferentColor(grid, row + 1, col, surroundedColor, newColor);
            markDifferentColor(grid, row - 1, col, surroundedColor, newColor);
            markDifferentColor(grid, row, col + 1, surroundedColor, newColor);
            markDifferentColor(grid, row, col - 1, surroundedColor, newColor);
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        int i = new NumberOfEnclaves().numEnclaves(grid);
        System.out.println(i);
    }
}


//    private int countNoOfEnclaves(int[][] grid, int row, int col, int surroundedColor) {
//        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1) {
//            return 0;
//        }
//        if (grid[row][col] == surroundedColor) {
//            grid[row][col] = 0;
//            return (1 + countNoOfEnclaves(grid, row + 1, col, surroundedColor) + countNoOfEnclaves(grid, row - 1, col, surroundedColor) + countNoOfEnclaves(grid, row, col + 1, surroundedColor) + countNoOfEnclaves(grid, row, col - 1, surroundedColor));
//        } else {
//            return 0;
//        }
//    }
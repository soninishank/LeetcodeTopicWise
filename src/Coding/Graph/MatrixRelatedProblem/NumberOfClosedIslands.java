package Coding.Graph.MatrixRelatedProblem;

// https://leetcode.com/problems/number-of-closed-islands/
// 0 -> land  1 -> water
// We need to find the land which is surrounded by water
// see the grey area in the output - Q.1
// if the boundary is zero than we don't count it - Boundary DFS - similar like surrounded regions
// exact same code as Number of enclaves just than when we are counting we are doing inside dfs
public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        // 1. Firstly make all the boundary & its neighbouring cells to zero
        int surroundedColor = 0;
        int newColor = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // change color at boundaries
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
                    if (grid[i][j] == surroundedColor) {
                        changeTheColor(grid, i, j, surroundedColor, newColor); // change 0 to 1 which are at boundary
                    }
                }
            }
        }
        // 2. count the land which is surrounded by water
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == surroundedColor) {
                    count++; // we need to count once from a specific point
                    changeTheColor(grid, i, j, surroundedColor, newColor);
                }
            }
        }
        return count;
    }

    private void changeTheColor(int[][] grid, int row, int col, int surroundedColor, int maskColor) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1) {
            return;
        }
        if (grid[row][col] == surroundedColor) {
            grid[row][col] = maskColor;
            changeTheColor(grid, row + 1, col, surroundedColor, maskColor);
            changeTheColor(grid, row - 1, col, surroundedColor, maskColor);
            changeTheColor(grid, row, col + 1, surroundedColor, maskColor);
            changeTheColor(grid, row, col - 1, surroundedColor, maskColor);
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int i = new NumberOfClosedIslands().closedIsland(arr);
        System.out.println(i);
    }
}

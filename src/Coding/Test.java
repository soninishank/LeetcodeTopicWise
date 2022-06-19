package Coding;

public class Test {
    public int closedIsland(int[][] grid) {
        // Firstly make all the boundary & its neighbouring cells to zero
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
                    if (grid[i][j] == 0) {
                        markItZero(grid, i, j, 0, 1); // change 0 to 1 which are at boundary
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    countNoOfEnclaves(grid, i, j, 0);
                }
            }
        }
        return count;
    }

    private int countNoOfEnclaves(int[][] grid, int row, int col, int newColor) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1) {
            return 0;
        }
        if (grid[row][col] == newColor) {
            grid[row][col] = 1;
            return (
                    1 +
                            countNoOfEnclaves(grid, row + 1, col, newColor) +
                            countNoOfEnclaves(grid, row - 1, col, newColor) +
                            countNoOfEnclaves(grid, row, col + 1, newColor) +
                            countNoOfEnclaves(grid, row, col - 1, newColor)
            );
        } else {
            return 0;
        }
    }

    private void markItZero(int[][] grid, int row, int col, int newColor, int oldColor) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1) {
            return;
        }
        if (grid[row][col] == newColor) {
            grid[row][col] = oldColor;
            markItZero(grid, row + 1, col, newColor, oldColor);
            markItZero(grid, row - 1, col, newColor, oldColor);
            markItZero(grid, row, col + 1, newColor, oldColor);
            markItZero(grid, row, col - 1, newColor, oldColor);
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int ints = new Test().closedIsland(arr);
        System.out.println((ints));
    }
}

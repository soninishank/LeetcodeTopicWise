package Coding.Graph.MatrixRelatedProblem;

import java.util.LinkedList;
import java.util.Queue;

// count number of connected 1s present in matrix
// https://leetcode.com/problems/number-of-islands/
// you need to count the islands which are connected together in 4 directions
// 1 - island, 0 - water
// so you just need to count all the islands present in it - just start the dfs and start count
// then check other unconnected 1s
public class NumberOfIslands {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // 1.Apply Coding.BFS
    // TC - O(m * n)
    // SC - O(m * n)
    private int numIslandsBFS(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    applyBFS(queue, visited, grid);
                }
            }
        }
        return count;
    }

    private void applyBFS(Queue<int[]> queue, boolean[][] visited, char[][] grid) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0];
                int y = poll[1] + dir[1];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == '0')
                    continue;
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

    // 2.Apply DFS
    // TC - O(m * n)
    // SC - O(m * n)
    private int numIslandsDFS(char[][] grid) {
        int count = 0;
        char islandColor = '1';
        char maskColor = '*';
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == islandColor) {
                    count++;
                    applyDfs(i, j, grid, islandColor, maskColor);
                }
            }
        }
        return count;
    }

    private void applyDfs(int row, int col, char[][] grid, char islandColor, char maskColor) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == islandColor) {
            grid[row][col] = maskColor;
            applyDfs(row, col - 1, grid, islandColor, maskColor);
            applyDfs(row, col + 1, grid, islandColor, maskColor);
            applyDfs(row - 1, col, grid, islandColor, maskColor);
            applyDfs(row + 1, col, grid, islandColor, maskColor);
        }
    }


    public static void main(String[] args) {
        char[][] ch = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int i = new NumberOfIslands().numIslandsBFS(ch);
        System.out.println(i);
    }
}

//
//class Solution {
//    // Define possible movement directions (right, left, down, up) for DFS traversal
//    int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
//    int row = 0; // Total number of rows in the grid
//    int col = 0; // Total number of columns in the grid
//    int count = 0; // Counter to track the number of islands
//
//    // Method to count the number of islands in the grid
//    public int numIslands(char[][] grid) {
//        row = grid.length - 1; // Get the last index for rows
//        col = grid[0].length - 1; // Get the last index for columns
//
//        // Iterate over each cell in the grid
//        for (int i = 0; i <= row; i++) {
//            for (int j = 0; j <= col; j++) {
//                // If the cell contains '1', it is part of an island
//                if (grid[i][j] == '1') {
//                    count++; // Increment island count
//                    // Perform DFS to mark the entire island as visited
//                    applyDFS(grid, i, j);
//                }
//            }
//        }
//        return count; // Return the total number of islands
//    }
//
//    // DFS method to mark all connected '1's as '0'
//    private void applyDFS(char[][] grid, int i, int j) {
//        // Base case: If the index is out of bounds or the cell is '0', return
//        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == '0') {
//            return;
//        }
//
//        // Mark the current cell as visited by setting it to '0'
//        grid[i][j] = '0';
//
//        // Recursively call DFS on all 4 adjacent cells (up, down, left, right)
//        applyDFS(grid, i + 1, j); // Move down
//        applyDFS(grid, i - 1, j); // Move up
//        applyDFS(grid, i, j - 1); // Move left
//        applyDFS(grid, i, j + 1); // Move right
//        return; // Return after all adjacent cells are processed
//    }
//}

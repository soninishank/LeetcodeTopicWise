package Coding.Graph.MatrixRelatedProblem;

import java.util.LinkedList;
import java.util.Queue;

// whenever you find 1 - count total number of 1s
// get maximum value among those 1s
// firstly check if the current grid value is 1 -> apply DFS (return its value) - note max at every step
// https://leetcode.com/problems/max-area-of-island/
// similar like number of islands except that you need to maintain the max for every DFS call
public class MaxAreaIsland {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maxAreaOfIslandBFS(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int maxValue = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    maxValue = Math.max(1 + applyBFS(queue, visited, grid), maxValue);
                }
            }
        }
        return maxValue;
    }

    private int applyBFS(Queue<int[]> queue, boolean[][] visited, int[][] grid) {
        int count = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0];
                int y = poll[1] + dir[1];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 0)
                    continue;
                visited[x][y] = true;
                count++;
                queue.offer(new int[]{x, y});
            }
        }
        return count;
    }

    public int maxAreaOfIslandDFS(int[][] grid) {
        int maxCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    maxCount = Math.max(maxCount, 1 + dfsIsland(i, j, grid));// we need to take max of connected 1s
                }
            }
        }
        return maxCount;
    }

    private int dfsIsland(int row, int col, int[][] grid) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1) {
            grid[row][col] = '*';
            return 1 + dfsIsland(row, col - 1, grid) + dfsIsland(row, col + 1, grid) + dfsIsland(row - 1, col, grid) + dfsIsland(row + 1, col, grid);
        } else {
            return 0;
        }
    }

}

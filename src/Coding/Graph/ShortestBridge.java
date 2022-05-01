package Coding.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        // Apply DFS
        // 1.Find first island - color all its components means connected
        // 2.Find second island - add it in the queue
        // 3. run the BFS - if you find the newColor 2 then return the steps
        boolean isFirst = false;
        int newColor = 2;
        int islandColor = 1;
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !isFirst) {
                    applyDFS(grid, i, j, islandColor, newColor);
                    isFirst = true;
                }
                if (grid[i][j] == 1 && isFirst) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = 0;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : direction) {
                    int x = dir[0] + poll[0];
                    int y = dir[1] + poll[1];
                    if (x < 0 || y < 0 || i > grid.length - 1 || x > grid[0].length - 1) {
                        continue;
                    } else if (grid[x][y] == newColor) {
                        return steps;
                    } else if (grid[x][y] == 0) {
                        grid[x][y] = 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void applyDFS(int[][] grid, int i, int j, int currentColor, int newColor) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] != currentColor) {
            return;
        }
        grid[i][j] = newColor;
        applyDFS(grid, i + 1, j, currentColor, newColor);
        applyDFS(grid, i - 1, j, currentColor, newColor);
        applyDFS(grid, i, j + 1, currentColor, newColor);
        applyDFS(grid, i, j - 1, currentColor, newColor);
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {1, 0}};
        int i = new ShortestBridge().shortestBridge(arr);
        System.out.println(i);
    }
}

package Graph.MatrixRelatedProblem;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/
// you need to count the islands which are connected together in 4 directions
// if the island value is 1 - applyDFS - mark it as *
// then check other unconnected 1s
public class NumberIslands {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // 1.Apply BFS
    private int numIslandsBFS(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
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
    private int numIslandsDFS(char[][] grid) {
        int count = 0;
        char color = '1';
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == color) {
                    count++;
                    applyDfs(i, j, grid, color);
                }
            }
        }
        return count;
    }

    private void applyDfs(int row, int col, char[][] grid, int color) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == color) {
            grid[row][col] = '*';
            applyDfs(row, col - 1, grid, color);
            applyDfs(row, col + 1, grid, color);
            applyDfs(row - 1, col, grid, color);
            applyDfs(row + 1, col, grid, color);
        } else {
            return;
        }
    }


    public static void main(String[] args) {
        char[][] ch = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int i = new NumberIslands().numIslandsBFS(ch);
        System.out.println(i);
    }
}
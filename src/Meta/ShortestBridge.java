package Meta;

import java.util.LinkedList;
import java.util.Queue;

//  * Use DFS + BFS to solve this WONDERFUL problem!
//     * Step 1: use DFS to mark the first island to another number
//     * Step 2: start from the first island, doing BFS level order traversal to find number of bridges (levels)
//     * until reach the second island
// https://leetcode.com/problems/shortest-bridge/

public class ShortestBridge {

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private Queue<int[]> queue = new LinkedList<>();    // store visited cells with x and y in an array
    private int[][] grid;
    private int row, col;

    public int shortestBridge(int[][] A) {
        grid = A;
        row = A.length;
        col = A[0].length;
        boolean[][] visited = new boolean[row][col];
        boolean found = false;

        // 1. dfs to find an island, mark its cells in visited - add all the first island elements in a queue
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (found) {
                    break;
                }
                if (A[i][j] == 1) {
                    dfs(visited, i, j);
                    found = true;
                    if (found) {
                        break;
                    }
                }
            }
        }
        // 2. bfs to expand this island to reach another island
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                // Iterate in all four directions
                for (int[] d : dirs) {
                    int x = cell[0] + d[0];
                    int y = cell[1] + d[1];
                    if (x >= 0 && y >= 0 && x < row && y < col && !visited[x][y]) {    // Not in current island
                        // If we find the island with value 1 - it means we got a second island
                        if (A[x][y] == 1) {
                            return step;
                        }
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y] || grid[x][y] == 0) {
            return;
        }
        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        for (int[] d : dirs) {
            dfs(visited, x + d[0], y + d[1]);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {1, 0}};
        int i = new ShortestBridge().shortestBridge(arr);
        System.out.println(i);
    }
}

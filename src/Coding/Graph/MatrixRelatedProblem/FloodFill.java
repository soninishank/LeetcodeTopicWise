package Coding.Graph.MatrixRelatedProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// coloring with newColor the old colors
// https://leetcode.com/problems/flood-fill/
public class FloodFill {
    // 1 : using Coding.BFS
    private int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        for (boolean[] row : visited) Arrays.fill(row, false);
        int initialColour = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        // int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
        // int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            for (int i = 0; i < dx.length; i++) {

                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];

                if (isSafeToFill(x, y, m, n) && !visited[x][y] && image[x][y] == initialColour) {
                    image[x][y] = newColor;
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }
        return image;
    }

    private boolean isSafeToFill(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // 2: Using DFS
    private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int currentColor, int newColor) {
        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length && image[sr][sc] == currentColor) {
            image[sr][sc] = newColor;
            dfs(image, sr, sc + 1, currentColor, newColor);
            dfs(image, sr, sc - 1, currentColor, newColor);
            dfs(image, sr + 1, sc, currentColor, newColor);
            dfs(image, sr - 1, sc, currentColor, newColor);
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] ints = new FloodFill().floodFill(image, sr, sc, newColor);
        System.out.println(Arrays.deepToString(ints));
    }
}

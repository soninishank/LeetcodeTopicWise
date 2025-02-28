package Coding.Graph.MatrixRelatedProblem;

import java.util.LinkedList;
import java.util.Queue;

// Path :  top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1))

// If there is a 1 , we can't go.

// Shortest Path : Apply BFS - which works best
// 8 directional
// the path value must start from 0 - different from other questions
// Instead of having extra visited set - just mark them with *
// once you reached the last row and last column - return distance
// https://leetcode.com/problems/shortest-path-in-binary-matrix/
// All the visited cells of the path are 0.
// 1091. Shortest Path in Binary Matrix
// TC - O(N^2) - grid traversal
// SC - O(N^2) - visited set can hold upto N^2 elements
public class ShortestPathInBinaryMatrix {

    private final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    Queue<int[]> queue = new LinkedList<>();
    int distance = 0;

    public int shortestPathBinaryMatrix(int[][] grid) {
        int totalRow = grid.length;
        int totalCol = grid[0].length;
        if (totalRow == 0) {
            return -1;
        }
        if (grid[0][0] != 0) {
            return -1;
        }
        queue.add(new int[]{0, 0});
        grid[0][0] = '*';
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                // reached final row and column
                if (poll[0] == totalRow - 1 && poll[1] == totalCol - 1) {
                    return distance;
                }
                for (int[] direction : dir) {
                    int x = poll[0] + direction[0];
                    int y = poll[1] + direction[1];
                    if (x < 0 || y < 0 || x > totalRow - 1 || y > totalCol - 1) {
                        continue;
                    }
                    if (grid[x][y] != 0) {
                        continue;
                    }
                    queue.add(new int[]{x, y});
                    grid[x][y] = '*'; // mark visited
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1, 1, 0}, {0, 1, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 0, 0, 1, 1, 0}, {0, 1, 1, 1, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int i = new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid);
        System.out.println(i);
    }
}

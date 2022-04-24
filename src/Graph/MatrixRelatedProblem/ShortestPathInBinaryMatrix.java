package Graph.MatrixRelatedProblem;

import java.util.LinkedList;
import java.util.Queue;

// Path :  top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1))
// Shortest Path : Apply BFS - which works best
// 8 directional
// the path value must start from 0 - different from other questions
// Instead of having extra visited set - just mark them with *
// once you reached the last row and last column - return distance
// https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class ShortestPathInBinaryMatrix {

    private int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

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
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                distance++;
                if (poll[0] == totalRow - 1 && poll[1] == totalCol - 1) {
                    return distance + 1;
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
                    grid[x][y] = '*';
                }
            }
            distance++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1, 1, 0}, {0, 1, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 0, 0, 1, 1, 0}, {0, 1, 1, 1, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int i = new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid);
        System.out.println(i);
    }
}

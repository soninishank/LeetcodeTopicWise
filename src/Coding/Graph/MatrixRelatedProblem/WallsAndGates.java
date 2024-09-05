package Coding.Graph.MatrixRelatedProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 0 -> gate
// -1 -> obstacle
// https://leetcode.com/problems/walls-and-gates/
// Normal BFS traversal
public class WallsAndGates {

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // TC - O(m * n)
    // SC - O(m * n)
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;

        int GATE = 0;
        int EMPTY = Integer.MAX_VALUE;

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all gates to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Step 2: BFS from each gate
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] direction : dir) {
                    int x = direction[0] + poll[0];
                    int y = direction[1] + poll[1];
                    // empty room direction
                    if (x >= 0 && y >= 0 && x <= rooms.length - 1 && y <= rooms[0].length - 1 && rooms[x][y] == EMPTY) {
                        int value = rooms[poll[0]][poll[1]] + 1;
                        rooms[x][y] = Math.min(value, rooms[x][y]); // it is not needed because it is already minimum
                        queue.add(new int[]{x, y});// due to the nature of the BFS
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{2147483647, 0, 2147483647, 2147483647, 0, 2147483647, -1, 2147483647}};
        new WallsAndGates().wallsAndGates(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}

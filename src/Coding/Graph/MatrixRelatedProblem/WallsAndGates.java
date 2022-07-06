package Coding.Graph.MatrixRelatedProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 0 - gate
// https://leetcode.com/problems/walls-and-gates/
// Normal BFS traversal
public class WallsAndGates {

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Queue<int[]> queue = new LinkedList<>();

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] direction : dir) {
                    int x = direction[0] + poll[0];
                    int y = direction[1] + poll[1];
                    if (x >= 0 && y >= 0 && x <= rooms.length - 1 && y <= rooms[0].length - 1 && rooms[x][y] == 2147483647) {
                        int value = rooms[poll[0]][poll[1]] + 1;
                        rooms[x][y] = Math.min(value, rooms[x][y]);
                        queue.add(new int[]{x, y});
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

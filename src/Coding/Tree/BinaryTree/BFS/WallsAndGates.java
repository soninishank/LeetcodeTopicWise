package Coding.Tree.BinaryTree.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] arr : dir) {
                int x = arr[0] + poll[0];
                int y = arr[1] + poll[1];
                if (x < 0 || y < 0 || x > rooms.length - 1 || y > rooms.length - 1 || rooms[x][y] != Integer.MAX_VALUE)
                    continue;
                rooms[x][y] = rooms[poll[0]][poll[1]] + 1;
                queue.add(new int[]{x, y});
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE}, {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1}, {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1}, {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};
        new WallsAndGates().wallsAndGates(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}

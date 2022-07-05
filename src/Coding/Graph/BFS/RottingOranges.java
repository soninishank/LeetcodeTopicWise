package Coding.Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/
// in this you need to collect all data in the queue which are rotten
// Given : any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
// 1. Firstly count all fresh oranges
// 2. Put all rotten oranges in a queue
// 3. iterate queue and check if any adjacent neighbour is fresher than mark it as rotten and reduce count
// 4. Note time after every iteration
public class RottingOranges {
    int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int fresh_count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh_count++;
                }
            }
        }
        if (fresh_count == 0) {
            return 0;
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int arr[] : dir) {
                    int x = poll[0] + arr[0];
                    int y = poll[1] + arr[1];
                    if (x >= 0 && y >= 0 && x <= grid.length - 1 && y <= grid[0].length - 1 && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                        fresh_count--;
                    }
                }
            }
            time++;
            if (fresh_count == 0) {
                return time;
            }
        }
        if (fresh_count != 0) {
            return -1;
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int i = new RottingOranges().orangesRotting(arr);
        System.out.println(i);
    }
}


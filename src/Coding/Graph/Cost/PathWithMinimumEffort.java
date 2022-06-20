package Coding.Graph.Cost;

import java.util.PriorityQueue;

// https://leetcode.com/problems/path-with-minimum-effort/
public class PathWithMinimumEffort {

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        priorityQueue.add(new int[]{0, 0, 0});// source,destination,distance
        // we will create a matrix which can store all the maximum difference
        Integer[][] minDistanceMatrix = new Integer[heights.length][heights[0].length];
        minDistanceMatrix[0][0] = 0;// initial distance is zero
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            int source = poll[0];
            int destination = poll[1];
            int currentDistance = poll[2];

            if (source == heights.length - 1 && destination == heights[0].length - 1) {
                return currentDistance;
            }
            for (int k = 0; k < dir.length; k++) {
                int newRow = source + dir[k][0];
                int newCol = destination + dir[k][1];
                if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length) {
                    int newDistance = Math.max(currentDistance, Math.abs(heights[newRow][newCol] - heights[source][destination]));
                    if (minDistanceMatrix[newRow][newCol] == null || minDistanceMatrix[newRow][newCol] > newDistance) {
                        minDistanceMatrix[newRow][newCol] = newDistance;
                        priorityQueue.add(new int[]{newRow, newCol, newDistance});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        int i = new PathWithMinimumEffort().minimumEffortPath(matrix);
        System.out.println(i);
    }
}

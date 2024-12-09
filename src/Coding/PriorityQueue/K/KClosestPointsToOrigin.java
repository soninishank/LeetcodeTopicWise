package Coding.PriorityQueue.K;

import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
// you need smallest
// largest you can remove
// maxHeap is needed
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        // Priority Queue to store points with the farthest distances at the top
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> calculateEuclideanDistance(b) - calculateEuclideanDistance(a));

        // Add points to the maxHeap
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the farthest point if heap size exceeds k
            }
        }

        // Convert the heap into the result array
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    // Calculate squared Euclidean distance (no need for Math.sqrt for comparison)
    private int calculateEuclideanDistance(int[] point) {
        // basic way
//        int x1 = point[0];
//        int y1 = point[1];
//
//        int diff1 = x1 - 0;
//        int diff2 = y1 - 0;
//
//        double res = Math.pow(diff1, 2) + Math.pow(diff2, 2);
//        return (int) res;

        return point[0] * point[0] + point[1] * point[1];
    }


}
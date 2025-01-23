package Coding.Amazon.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// Squared distance = x^2 + y^2
// Point B : b[0] * b[0]+b[1] * b[1]
// Point A : a[0] * a[0] + a[1] * a[1]
// compare ->  Point B -  Point A
public class _14_KClosestPointsToOrigin {
    public List<int[]> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
                Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<int[]> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        _14_KClosestPointsToOrigin solver = new _14_KClosestPointsToOrigin();
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        int k = 1;
        List<int[]> result = solver.kClosest(points, k);
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}

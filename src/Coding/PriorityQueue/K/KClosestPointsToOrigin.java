package Coding.PriorityQueue.K;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
// you need smallest
// largest you can remove
// maxHeap is needed
public class KClosestPointsToOrigin {

    EuclideanDistance euclideanDistance = new EuclideanDistance();

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<EuclideanDistance> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.distance - o1.distance);
        for (int arr[] : points) {
            int distance = euclideanDistance.calDistance(arr);
            priorityQueue.add(new EuclideanDistance(distance,arr));
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        int[][] result = new int[priorityQueue.size()][2];
        int i = 0;
        while (!priorityQueue.isEmpty()){
            result[i] = priorityQueue.poll().points;
            i++;
        }
        return result;
    }
}

class EuclideanDistance {
    int distance;
    int points[];

    public EuclideanDistance(int distance, int[] points) {
        this.distance = distance;
        this.points = points;
    }

    public EuclideanDistance() {
    }

    int calDistance(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}

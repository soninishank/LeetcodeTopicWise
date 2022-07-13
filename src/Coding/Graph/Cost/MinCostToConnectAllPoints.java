//package Coding.Graph.Cost;
//
//import java.util.*;
//
//public class MinCostToConnectAllPoints {
//
//
//    public int minCostConnectPoints(int[][] points) {
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
//        int totalCost = 0;
//        priorityQueue.add(new int[]{0, 0});
//        Set<Integer> visitedSet = new HashSet<>();
//        while (!priorityQueue.isEmpty() && visitedSet.size() < points.length) {
//            int[] poll = priorityQueue.poll();
//            int source = poll[1];
//            int currentCost = poll[2];
//            if (visitedSet.contains(source)) {
//                continue;
//            }
//            totalCost += currentCost;
//            for (int i = 0; i < points.length; i++) {
//                if (visitedSet.contains(points[i])) {
//                    continue;
//                }
//                int absDiff = Math.abs(points[i][0] - points[source][0]) + Math.abs(points[i][1] - points[source][1]);
//                priorityQueue.add(new int[]{points[i], absDiff});
//            }
//        }
//    }
//
//    private int getCost(int[] points) {
//
//    }
//
//    public static void main(String[] args) {
//        int[][] arr = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
//        int i = new MinCostToConnectAllPoints().minCostConnectPoints(arr);
//        System.out.println(i);
//    }
//}

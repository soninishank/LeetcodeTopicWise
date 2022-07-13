package Coding.Graph.Cost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class CheapestFlightWithinKStops {
    private List<List<int[]>> adjList = new ArrayList<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int destination, int K) {
        // Build the adjacency matrix - directed
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] c : flights) {
            adjList.get(c[0]).add(new int[]{c[1], c[2]});
        }
        // Shortest distances array
        int[] distances = new int[n];
        // Shortest steps array
        int[] currentStops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        distances[src] = 0;
        currentStops[src] = 0;
        // The priority queue would contain (node, cost, stops)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});
        while (!minHeap.isEmpty()) {
            int[] info = minHeap.poll();
            int currentNode = info[0], currentNodeCost = info[1], currentNoOfStops = info[2];
            // If destination is reached, return the cost to get here
            if (currentNode == destination) {
                return currentNodeCost;
            }
            // If there are no more steps left, continue
            if (currentNoOfStops > K) {
                continue;
            }
            // Now apply bellman fordExamine and relax all neighboring edges if possible
            for (int[] neighbour : adjList.get(currentNode)) {
                int neighbourDest = neighbour[0];
                int neighbourCost = neighbour[1];
                // Better cost
                if (currentNodeCost + neighbourCost < distances[neighbourDest]) {
                    minHeap.add(new int[]{neighbourDest, currentNodeCost + neighbourCost, currentNoOfStops + 1});
                    distances[neighbourDest] = currentNodeCost + neighbourCost;
                } else if (currentNoOfStops < currentStops[neighbourDest]) {
                    minHeap.add(new int[]{neighbourDest, currentNodeCost + neighbourCost, currentNoOfStops + 1});
                }
                currentStops[neighbourDest] = currentNoOfStops;
            }
        }
        return distances[destination] == Integer.MAX_VALUE ? -1 : distances[destination];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;
        int cheapestPrice = new CheapestFlightWithinKStops().findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cheapestPrice);
    }
}

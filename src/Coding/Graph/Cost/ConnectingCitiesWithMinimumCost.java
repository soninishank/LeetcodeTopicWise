package Coding.Graph.Cost;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/connecting-cities-with-minimum-cost/
// connections[i] = [xi, yi, costi]
// Return the minimum cost to connect all the n cities
// use of priorityQueue - just need to make sure that you have visited all the cities
public class ConnectingCitiesWithMinimumCost {

    private List<List<int[]>> adjList = new ArrayList<>();
    private HashSet<Integer> visitedSet = new HashSet<>();

    public int minimumCost(int n, int[][] connections) {
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        // c[2] is the cost c[1] is destination
        for (int[] c : connections) {
            adjList.get(c[0]).add(new int[]{c[1], c[2]});
            adjList.get(c[1]).add(new int[]{c[0], c[2]});
        }
        // sort priorityQueue by cost
        int totalCost = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        priorityQueue.add(new int[]{1, 0}); // queue contains source which is starting from 0 and the initial cost is 0
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            if (visitedSet.contains(poll[0])) {
                continue;
            }
            visitedSet.add(poll[0]);
            totalCost += poll[1];
            for (int[] neighbour : adjList.get(poll[0])) {
                if (!visitedSet.contains(neighbour[0])) {
                    priorityQueue.add(new int[]{neighbour[0], neighbour[1]});
                }
            }
        }
        return visitedSet.size() == n ? totalCost : -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        int i = new ConnectingCitiesWithMinimumCost().minimumCost(n, connections);
        System.out.println(i);
    }
}

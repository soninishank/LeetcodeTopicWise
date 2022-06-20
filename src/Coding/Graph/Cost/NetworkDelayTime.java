package Coding.Graph.Cost;

import java.util.*;

// Djikstra Algorithm
// one with the lowest cost - can be pulled out first
// K - from which we need to start
// n - total no of vertices
// create min priorityQueue
// https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create an adjacency list from source to destination with weight
        Map<Integer, List<WeightData>> hashMap = new HashMap<>();
        for (int[] time : times) {
            hashMap.putIfAbsent(time[0], new ArrayList<>());
            hashMap.get(time[0]).add(new WeightData(time[1], time[2]));
        }
        // visited nodes
        Set<Integer> visited = new HashSet<>();
        // create a Min PriorityQueue
        PriorityQueue<WeightData> priorityQueue = new PriorityQueue<>((a, b) -> (a.distance - b.distance));
        int totalCost = 0;
        priorityQueue.offer(new WeightData(k, 0)); // start from k vertices and distance is 0
        while (!priorityQueue.isEmpty()) {
            int size = priorityQueue.size();
            for (int i = 0; i < size; i++) {
                WeightData poll = priorityQueue.poll();
                if (visited.contains(poll.destination)) {
                    continue;
                }
                visited.add(poll.destination);
                totalCost = Math.max(totalCost, poll.distance);
                if (visited.size() == n) {
                    return totalCost;
                }
                if (hashMap.containsKey(poll.destination)) {
                    for (WeightData weightData : hashMap.get(poll.destination)) {
                        int newDistance = poll.distance + weightData.distance;
                        priorityQueue.add(new WeightData(weightData.destination, newDistance));
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        int i = new NetworkDelayTime().networkDelayTime(times, n, k);
        System.out.println(i);
    }
}

class WeightData {
    int destination;
    int distance;

    public WeightData(int destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }
}

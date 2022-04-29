package Coding.Graph;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= N; ++i) graph.put(i, new ArrayList<>());
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        // Bellman-Ford (SPFA) to compute the shortest path from K to all other nodes.
        Integer[] cost = new Integer[N + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        cost[K] = 0;
        queue.add(K);
        while (queue.size() > 0) {
            int currNode = queue.remove();
            for (int[] adjacentNode : graph.get(currNode)) {
                if (cost[adjacentNode[0]] == null || cost[currNode] + adjacentNode[1] < cost[adjacentNode[0]]) {
                    cost[adjacentNode[0]] = cost[currNode] + adjacentNode[1];
                    queue.addLast(adjacentNode[0]);
                }
            }
        }

        int result = 0;
        for (int i = 1; i < cost.length; ++i) {
            if (cost[i] == null) return -1;
            result = Math.max(result, cost[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        int i = new NetworkDelayTime().networkDelayTime(times, n, k);
        System.out.println(i);
    }


}

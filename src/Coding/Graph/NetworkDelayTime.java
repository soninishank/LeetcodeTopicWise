package Coding.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/network-delay-time/
class NetworkDelayTime {
    // Adjacency list
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        //distance, node into pq
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[]{0, K});
        boolean[] visited = new boolean[N + 1]; //because starting from 1 ,N = 4 so N = 1 to 4
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int nodeDistance = cur[0];
            int currentNode = cur[1];
            if (visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;
            res = nodeDistance;
            N--;
            if (map.containsKey(currentNode)) {
                // visit its neighbouring node
                for (int neighbour : map.get(currentNode).keySet()) {
                    pq.add(new int[]{nodeDistance + map.get(currentNode).get(neighbour), neighbour});
                }
            }
        }
        return N == 0 ? res : -1;
    }

    public static void main(String[] args) {
        // u,v,w -> w is the weight
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        int i = new NetworkDelayTime().networkDelayTime(times, n, k);
        System.out.println(i);
    }
}
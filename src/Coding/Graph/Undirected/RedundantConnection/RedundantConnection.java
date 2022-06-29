package Coding.Graph.Undirected.RedundantConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/redundant-connection/
// detect cycle in undirected graph while creating an adjacencyList
public class RedundantConnection {

    List<List<Integer>> adjList = new ArrayList<>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adjList = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            if (applyDFS(edge[0], edge[1], adjList, new HashSet<Integer>())) {
                return edge;
            } else {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }
        }
        return null;
    }

    private boolean applyDFS(int source, int target, List<List<Integer>> adjList, HashSet<Integer> visitedSet) {
        if (!visitedSet.contains(source)) {
            visitedSet.add(source);
            if (source == target) {
                return true;
            }
            for (int neighbours : adjList.get(source)) {
                if (applyDFS(neighbours, target, adjList, visitedSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] redundantConnection = new RedundantConnection().findRedundantConnection(edges);
        System.out.println(Arrays.toString(redundantConnection));
    }
}

package Coding.Graph.Undirected;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
// whenever there is undirected graph you need a visited array because they are cyclic in nature
public class NumberOfUnconnectedComponentsInAGraph {
    List<List<Integer>> adjList = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();

    // Using DFS : O(V+E) where V is the number of nodes.
    // Space : O(V+E) because of adjacencyList
    // E is the number of edges.
    public int countComponents(int n, int[][] edges) {
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // Build the adjacency list
        for (int[] arr : edges) {
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        int count = 0;

        // Perform DFS for each unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                visited.add(i);// start will be 0
                count++;
                applyDFS(adjList, i, visited);
            }
        }
        return count;
    }

    private void applyDFS(List<List<Integer>> adjList, int currentNode, HashSet<Integer> visited) {
        for (int neighbouring : adjList.get(currentNode)) {
            if (!visited.contains(neighbouring)) {
                visited.add(neighbouring);
                applyDFS(adjList, neighbouring, visited);
            }
        }
    }


    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int i = new NumberOfUnconnectedComponentsInAGraph().countComponents(n, edges);
        System.out.println(i);
    }
}

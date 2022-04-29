package Coding.Graph.Undirected;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/graph-valid-tree/
public class GraphValidTree {
    List<List<Integer>> adjList;
    HashSet<Integer> visited;

    private boolean validTree(int n, int[][] edges) {
        adjList = new ArrayList<>(n);
        visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // link edges
        for (int[] arr : edges) {
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                if (hasCycle(visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(HashSet<Integer> visited, int current, int parent) {
        for (int neighbour : adjList.get(current)) {
            if (!visited.contains(neighbour)) {
                visited.add(neighbour);
                hasCycle(visited, neighbour, current);
            }
            // If the adjacent node is not parent and already visited then return true.
            else if (neighbour != parent) { // if its already visited and its parent is not equal to neighbour
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        boolean b = new GraphValidTree().validTree(5, edges);
        System.out.println(b);
    }
}

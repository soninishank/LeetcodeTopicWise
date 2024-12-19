package Coding.Graph.Undirected.GraphValidTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/graph-valid-tree/
// https://www.youtube.com/watch?v=Y9NFqI6Pzd4 : 6:11
// https://leetcode.com/problems/graph-valid-tree/ TODO: Good article
// Detect a cycle in undirected graph
// A graph is a valid tree if:
// 1. It is connected: All nodes can be reached starting from any single node.
// 2. It is acyclic: There are no cycles.
// Time complexity - O(N + E) : Creating the adjacency list requires initialising a list of length NN, with a cost of O(N), and then iterating over and inserting E edges, for a cost of O(E). This gives us O(E) + O(N) = O(N + E) =O(N+E).
// Space Complexity : O(N + E)
// The adjacency list is a list of length N, with inner lists with lengths that add to a total of E. This gives a total of  // O(N+E) space.
public class GraphValidTree {
    List<List<Integer>> adjList;
    HashSet<Integer> visited;

    public boolean validTree(int n, int[][] edges) {
        adjList = new ArrayList<>(n);
        visited = new HashSet<>();
        // 1. Builds the adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // 2.link edges
        for (int[] arr : edges) {
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        // 3. DFS for Cycle Detection -> Start DFS from node 0
        if (hasCycle(0, -1)) {
            return false; // Cycle detected, not a valid tree
        }
        // Check connectivity: All nodes should be visited
        return visited.size() == n;
    }

    private boolean hasCycle(int current, int parent) {
        visited.add(current);

        for (int neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                if (hasCycle(neighbor, current)) {
                    return true; // Cycle detected in deeper recursion
                } // 4. Visiting an already visited node that is not the parent (indicates a cycle).
            } else if (neighbor != parent) {
                // If the neighbor is visited and not the parent, a cycle exists
                return true;
            }
        }
        return false;
    }

}
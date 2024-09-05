package Coding.Graph.Directed;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Arrays to keep track of visited and the current path (dfsVisited)
        boolean visited[] = new boolean[V];
        boolean dfsVisited[] = new boolean[V];

        // For every node, check if there's a cycle starting from that node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycle(adj, visited, dfsVisited, i)) { // if any cycle is found
                    return true;
                }
            }
        }
        return false;
    }

    // Recursive function to detect cycle using DFS
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean dfsVisited[], int current) {
        // Mark the current node as visited and part of the current DFS recursion stack
        visited[current] = true;
        dfsVisited[current] = true;

        // Explore the neighbors
        for (int neighbor : adj.get(current)) {
            if (!visited[neighbor]) {
                if (isCycle(adj, visited, dfsVisited, neighbor)) {
                    return true;
                }
            } else if (dfsVisited[neighbor]) {
                return true; // Cycle detected
            }
        }

        // Remove the current node from the DFS recursion stack
        dfsVisited[current] = false;
        return false;
    }

    // Helper function to create the adjacency list from the edges
    public ArrayList<ArrayList<Integer>> createAdjList(int[][] edges, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        return adj;
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph();
        int V = 4; // Number of vertices
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}}; // Edges of the graph

        // Create the adjacency list from the edges
        ArrayList<ArrayList<Integer>> adj = graph.createAdjList(edges, V);

        if (graph.isCyclic(V, adj)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph doesn't contain a cycle");
        }
    }
}

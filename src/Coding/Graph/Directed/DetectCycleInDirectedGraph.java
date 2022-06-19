package Coding.Graph.Directed;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
// https://www.youtube.com/watch?v=uzVUw90ZFIg
public class DetectCycleInDirectedGraph {
    private boolean isCyclic(int[][] graph, int edges) {
        List<List<Integer>> adjList = new ArrayList<>(edges);
        for (int i = 0; i < edges; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            adjList.get(graph[i][0]).add(graph[i][1]);
        }
        boolean[] visited = new boolean[edges];
        boolean[] dfsVisited = new boolean[edges];
        for (int i = 0; i < edges; i++) {
            if (!visited[i]) {
                if (checkCyclic(i, visited, dfsVisited, adjList)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCyclic(int parent, boolean[] visited, boolean[] dfsVisited, List<List<Integer>> adjList) {
        // visited in both - return true - cycle present
        if (dfsVisited[parent] && visited[parent]) {
            return true;
        }
        // mark both as visited
        dfsVisited[parent] = true;
        visited[parent] = true;
        for (Integer child : adjList.get(parent)) {
            // if child is not visited - check cyclicity
            if (!visited[child]) {
                if (checkCyclic(child, visited, dfsVisited, adjList)) {
                    return true;
                }
            }// if DFSChild is visited  - cycle
            else if (dfsVisited[child]) {
                return true;
            }
            dfsVisited[parent] = false; // backtrack
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph();
        int[][] arr = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}};
        if (graph.isCyclic(arr, 4)) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't " + "contain cycle");
        }
    }


}

package Coding.Graph.Undirected;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DetectCycleInUndirectedGraph {

    List<List<Integer>> adjList;
    HashSet<Integer> visited;

    private boolean isCycle(int[][] edges, int n) {
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

    // parent means previous value which is already visited 
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
        int[][] arr = {{0, 1}, {1, 2}, {2, 3}, {0, 2}};
        int n = 4;
        boolean cycle = new DetectCycleInUndirectedGraph().isCycle(arr, n);
        System.out.println(cycle);
    }
}

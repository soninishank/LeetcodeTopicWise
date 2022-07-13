package Coding.Graph.Directed;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int size = graph.length;
        boolean[] visited = new boolean[size];
        boolean[] dfsVisited = new boolean[size];
        boolean[] presentCycle = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                DFSrecursive(i, visited, dfsVisited, graph, presentCycle);
            }
        }
        for (int i = 0; i < presentCycle.length; i++) {
            if (!presentCycle[i]) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean DFSrecursive(int source, boolean[] visited, boolean[] dfsVisited, int[][] graph, boolean[] presentCycle) {
        visited[source] = true;
        dfsVisited[source] = true;
        for (int neigh : graph[source]) {
            if (!visited[neigh]) {
                if (DFSrecursive(neigh, visited, dfsVisited, graph, presentCycle)) {
                    return presentCycle[source] = true;
                }
            } else if (visited[neigh] && dfsVisited[neigh]) {
                return presentCycle[source] = true;
            }
        }
        dfsVisited[source] = false;
        return false;
    }





    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        List<Integer> list = new EventualSafeStates().eventualSafeNodes(arr);
        System.out.println(list);
    }
}

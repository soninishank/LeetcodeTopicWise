package Coding.Graph.Directed;

import java.util.ArrayList;
import java.util.List;

// // [[4,3,1],[3,2,4],[3],[4],[]]
//// It means at index 0 -> [4,3,1] means 0 is connected to 4,3,1
//// At index 1 -> [3,2,1] means 1 is connected to 3,2,4
//// At index 2 -> [3] means 2 is connected to 3
//// At index 3 -> [4] means 3 is connected to 4
//// at index 4 -> [] means no connection
// https://leetcode.com/problems/all-paths-from-source-to-target/
public class AllPathsFromSourceToTarget {
    List<List<Integer>> adjList;
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int edges = graph.length;
        // Build graph
        adjList = new ArrayList<>(edges);
        for (int i = 0; i < edges; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0); // adding this because in answer we need to add 0 because 0
        applyBacktracking(adjList, 0, edges - 1, list);
        return resultList;
    }

    // only source is getting changed
    private void applyBacktracking(List<List<Integer>> adjList, int source, int destination, ArrayList<Integer> arrayList) {
        if (source == destination) {
            resultList.add(new ArrayList<>(arrayList));
            return;
        }
        for (int neighbour : adjList.get(source)) {
            arrayList.add(neighbour);
            applyBacktracking(adjList, neighbour, destination, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> lists = new AllPathsFromSourceToTarget().allPathsSourceTarget(graph);
        System.out.println(lists);
    }
}

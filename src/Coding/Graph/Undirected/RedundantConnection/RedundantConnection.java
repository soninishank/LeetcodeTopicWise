package Coding.Graph.Undirected.RedundantConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/redundant-connection/
// detect cycle in undirected graph while creating an adjacencyList
// similarly think like a GraphValidTree question
public class RedundantConnection {

    List<List<Integer>> adjList = new ArrayList<>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adjList = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        // We want to check whether we can connect this edges or not
        for (int[] edge : edges) {
            if (applyDFS(edge[0], edge[1], adjList, new HashSet<>())) {
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

// Adjacency List
// 1 -> 2,4,5
// 2 -> 3,1
// 3 -> 4,2
// 4 -> 3,1
// 5 -> 1

// Dry Run for {1,4}
// 1. source = 1 , dest = 4 , visited = {} , after that visited = 1
// 2. AdjList[1] = 2 , source = 2, dest = 4 , visited become = 1,2
// 3. AdjList[2] = {1,3} source = 1 , dest = 4 , return
//                       source = 3 , dest = 4 , visited becomes = 1,2,3
// 4. AdjList[3] = {2,4} source = 2 , dest = 4 , return
//                       source = 4 , dest = 4 , source == target -> its an edge - hurray
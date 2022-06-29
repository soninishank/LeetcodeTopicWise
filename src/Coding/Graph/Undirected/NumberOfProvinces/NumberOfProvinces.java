package Coding.Graph.Undirected.NumberOfProvinces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/number-of-provinces/
// similar like number of unconnected components in graph
// similar like - https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class NumberOfProvinces {
    List<List<Integer>> adjList = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // only check the condition while creating an adjacency list
        // only for 1 you need to create
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int count = 0;
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
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = new NumberOfProvinces().findCircleNum(isConnected);
        System.out.println(circleNum);
    }
}


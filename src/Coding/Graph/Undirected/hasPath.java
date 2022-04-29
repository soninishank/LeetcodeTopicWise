package Coding.Graph.Undirected;

import java.util.*;

public class hasPath {

    List<List<Integer>> adjList;

    public boolean validPathUsingBFS(int n, int[][] edges, int source, int destination) {
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // because undirected
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        HashSet<Integer> visitedSet = new HashSet<>();
        visitedSet.add(source);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Integer poll = queue.poll();
                if (poll == destination) {
                    return true;
                }
                for (int neighbour : adjList.get(poll)) {
                    if (!visitedSet.contains(neighbour)) {
                        queue.add(neighbour);
                        visitedSet.add(neighbour);
                    }
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // because undirected
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        visited[source] = true;
        return applyDFS(adjList, source, destination, visited);
    }

    private boolean applyDFS(List<List<Integer>> adjList, int source, int destination, boolean[] visited) {
        if (source == destination) {
            return true;
        }
        for (int neighbour : adjList.get(source)) {
            if (visited[neighbour] == false) {
                visited[neighbour] = true;
                applyDFS(adjList, neighbour, destination, visited);
            }
        }
        return false;
    }
}

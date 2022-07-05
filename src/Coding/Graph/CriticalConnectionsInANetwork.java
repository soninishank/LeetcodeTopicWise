package Coding.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// critical connection is a connection when we remove one edge it can lead to generation of two separate component
// If we remove any edge that exists in a cycle then that edge will not be a critical connection of that graph
// 1 -> 2 -> 3 -> 4 all are connected linearly so every edge is a critical connection
public class CriticalConnectionsInANetwork {

    private int nextId = 0;
    private List<List<Integer>> resultList = new ArrayList<>();
    private HashSet<Integer> visitedSet = new HashSet<>();
    List<List<Integer>> adjList = new ArrayList<>();
    int[] lowestId;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        lowestId = new int[n];
        // undirected graph
        for (List<Integer> connection : connections) {
            adjList.get(connection.get(0)).add(connection.get(1));
            adjList.get(connection.get(1)).add(connection.get(0));
        }
        tarjansAlgorithm(-1, nextId);
        return resultList;
    }

    private void tarjansAlgorithm(int parentId, int currentId) {
        visitedSet.add(currentId);
        lowestId[currentId] = nextId;
        nextId++;
        int currentNodeLowestId = lowestId[currentId];
        for (int neighbourID : adjList.get(currentId)) {
            if (neighbourID == parentId) {
                continue;
            }
            if (!visitedSet.contains(neighbourID)) {
                tarjansAlgorithm(currentId, neighbourID);
            }
            lowestId[currentId] = Math.min(lowestId[currentId], lowestId[neighbourID]);
            if (currentNodeLowestId < lowestId[neighbourID]) {
                resultList.add(Arrays.asList(currentId, neighbourID));
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        List<List<Integer>> list = new CriticalConnectionsInANetwork().criticalConnections(n, connections);
        System.out.println(list);
    }
}

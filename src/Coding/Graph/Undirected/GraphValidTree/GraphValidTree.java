//package Coding.Graph.Undirected.GraphValidTree;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//// https://leetcode.com/problems/graph-valid-tree/
//// https://www.youtube.com/watch?v=Y9NFqI6Pzd4 : 6:11
//// https://leetcode.com/problems/graph-valid-tree/ TODO: Good article
//// Detect a cycle in undirected graph
//// Recall that a graph, G, is a tree iff the following two conditions are met:
////1.G is fully connected. In other words, for every pair of nodes in G, there is a path between them.
////2. G contains no cycles. In other words, there is exactly one path between each pair of nodes in G.
//// Time complexity - O(N+E) : Creating the adjacency list requires initialising a list of length NN, with a cost of O(N), and then iterating over and inserting E edges, for a cost of O(E). This gives us O(E) + O(N) = O(N + E) =O(N+E).
//// Space Complexity : O(N + E).
//// The adjacency list is a list of length N, with inner lists with lengths that add to a total of E. This gives a total of  // O(N+E) space.
//public class GraphValidTree {
//    private List<List<Integer>> adjacencyList = new ArrayList<>();
//    private Set<Integer> seen = new HashSet<>();
//
//
//    public boolean validTree(int n, int[][] edges) {
//        if (edges.length != n - 1) {
//            return false;
//        }
//        for (int i = 0; i < n; i++) {
//            adjacencyList.add(new ArrayList<>());
//        }
//        // linking
//        for (int[] edge : edges) {
//            adjacencyList.get(edge[0]).add(edge[1]);
//            adjacencyList.get(edge[1]).add(edge[0]);
//        }
//        // We return true iff no cycles were detected,
//        if (hasCycle(0, -1)) {
//            return false;
//        }
//        return seen.size() == n; // all the nodes have been traversed in one shot
//    }
//
//    private boolean hasCycle(int current, int parent) {
//        if (seen.contains(current)) {
//            return false;
//        }
//        seen.add(current);
//        for (int neighbour : adjacencyList.get(current)) {
//            if (parent != neighbour) {
//
//            }
//        }
//    }
//
//
//    public static void main(String[] args) {
//        int[][] edges = {{0, 1}, {2, 3}};
//        boolean b = new GraphValidTree().validTree(4, edges);
//        System.out.println(b);
//    }
//}

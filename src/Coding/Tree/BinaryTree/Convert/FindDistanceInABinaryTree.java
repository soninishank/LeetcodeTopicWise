package Coding.Tree.BinaryTree.Convert;

import Coding.Tree.TreeNode;

import java.util.*;

// https://leetcode.com/problems/find-distance-in-a-binary-tree/
// 1740. Find Distance in a Binary Tree
// Build a graph - adjacencyList
// For two points - start doing BFS from one point to the other using queue
public class FindDistanceInABinaryTree {
    // Adjacency list to represent the tree as an undirected graph
    private HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public int findDistance(TreeNode root, int node1, int node2) {
        if (root == null) {
            return 0; // If the tree is empty, the distance is 0
        }
        if (node1 == node2) {
            return 0; // The Distance between the same nodes is 0
        }
        // Build the adjacency list from the tree
        buildGraphFromTree(root);
        // Find the shortest distance between node1 and node2
        return calculateShortestDistance(node1, node2);
    }

    private void buildGraphFromTree(TreeNode root) {
        if (root == null) {
            return;
        }
        // Add edge between root and left child
        if (root.left != null) {
            adjacencyList.putIfAbsent(root.val, new ArrayList<>());
            adjacencyList.putIfAbsent(root.left.val, new ArrayList<>());

            adjacencyList.get(root.val).add(root.left.val);
            adjacencyList.get(root.left.val).add(root.val);

            buildGraphFromTree(root.left);
        }

        // Add edge between root and right child
        if (root.right != null) {
            adjacencyList.putIfAbsent(root.val, new ArrayList<>());
            adjacencyList.putIfAbsent(root.right.val, new ArrayList<>());

            adjacencyList.get(root.val).add(root.right.val);
            adjacencyList.get(root.right.val).add(root.val);

            buildGraphFromTree(root.right);
        }
    }

    private int calculateShortestDistance(int startNode, int targetNode) {
        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        // Set to keep track of visited nodes
        Set<Integer> visitedNodes = new HashSet<>();
        visitedNodes.add(startNode);

        int distance = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                int currentNode = queue.poll();
                // If we find the target node, return the distance
                if (currentNode == targetNode) {
                    return distance;
                }
                // Explore neighbors
                for (int neighbor : adjacencyList.get(currentNode)) {
                    if (!visitedNodes.contains(neighbor)) {
                        visitedNodes.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            // Increment distance for the next level
            distance++;
        }
        return distance; // Return the distance after BFS completes
    }
}

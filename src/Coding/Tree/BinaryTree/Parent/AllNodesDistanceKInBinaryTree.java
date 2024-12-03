package Coding.Tree.BinaryTree.Parent;

import Coding.Tree.TreeNode;

import java.util.*;

// Hashmap -> for storing the reference of parent pointers
// visited hashset -> to mark the visited node
// traversal - left, right, upwards - Coding.BFS
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// 863. All Nodes Distance K in Binary Tree
// 1. Build parent reference and put it in the hashmap
// 2. Do BFS traversal and use a visited node
public class AllNodesDistanceKInBinaryTree {
    private HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
    private List<Integer> resultList = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return resultList;
        }
        // Step 1: Build the parent reference map
        buildParentReference(root, null);

        // Step 2: Initialize the BFS queue and visited set
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        // Start BFS from the target node
        queue.add(target);
        visited.add(target);

        // Perform BFS to find all nodes at distance K
        while (!queue.isEmpty()) {
            int size = queue.size();
            k--;  // Decrease distance K as we move level by level
            if (k < 0) {
                break;  // If we've reached the required distance, stop further traversal
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                }
            }
        }
        // Step 3: Collect the nodes at distance K
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                resultList.add(node.val);
            }
        }
        // Return the final result
        return resultList;
    }

    // Helper method to build the parent reference map for each node
    private void buildParentReference(TreeNode root, TreeNode parentRef) {
        if (root == null) {
            return;
        }
        // Map the parent reference for the current node
        parentMap.put(root, parentRef);
        // Recursively build the parent reference for left and right children
        buildParentReference(root.left, root);
        buildParentReference(root.right, root);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.left.right = new TreeNode(4);

        treeNode.right.left = new TreeNode(0);
        treeNode.right.left.right = new TreeNode(8);

        List<Integer> list = new AllNodesDistanceKInBinaryTree().distanceK(treeNode, treeNode.left, 2);
        System.out.println(list);
    }
}

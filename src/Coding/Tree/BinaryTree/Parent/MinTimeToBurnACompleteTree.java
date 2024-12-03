package Coding.Tree.BinaryTree.Parent;

import Coding.Tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// Burn the binary tree starting from the target node
// https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/
// Three directions
// 1.left
// 2.right
// 3.Parent Node
// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
// Exactly same as https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class MinTimeToBurnACompleteTree {
    private HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        // Step 1: Find the start node in the tree
        TreeNode startNode = findNode(root, start);
        if (startNode == null) {
            return 0;  // If the start node does not exist, return 0
        }
        buildParentReference(root, null);
        // Step 2: Use the existing minTime function to calculate the time
        return minTime(root, startNode);
    }

    private TreeNode findNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return root;
        }
        TreeNode leftResult = findNode(root.left, value);
        if (leftResult != null) {
            return leftResult;
        }
        return findNode(root.right, value);
    }

    public int minTime(TreeNode root, TreeNode target) {
        int value = dfs(root, target, parentMap);
        return value;
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

    // when the adjacent node start burning they all start burning the nearby nodes at once
    private int dfs(TreeNode root, TreeNode target, HashMap<TreeNode, TreeNode> parentRefHashMap) {
        if (root == null) {
            return 0;
        }
        HashSet<TreeNode> visitedHashset = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visitedHashset.add(target);

        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // left
                if (poll.left != null && !visitedHashset.contains(poll.left)) {
                    queue.add(poll.left);
                    visitedHashset.add(poll.left);
                }
                // right
                if (poll.right != null && !visitedHashset.contains(poll.right)) {
                    queue.add(poll.right);
                    visitedHashset.add(poll.right);
                }
                // parent hash map - upward
                if (parentRefHashMap.get(poll) != null && !visitedHashset.contains(parentRefHashMap.get(poll))) {
                    queue.add(parentRefHashMap.get(poll));
                    visitedHashset.add(parentRefHashMap.get(poll));
                }
            }
            currentLevel++;
        }
        return currentLevel - 1;// Subtract 1 because we incremented at the last step
    }
}

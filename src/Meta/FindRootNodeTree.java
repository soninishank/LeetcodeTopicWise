package Meta;

import Coding.Tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindRootNodeTree {
    public static TreeNode findRoot(List<TreeNode> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null; // No tree, return null
        }
        // Set to store all child nodes
        HashSet<TreeNode> childNodes = new HashSet<>();
        // Add all left and right child nodes to the set
        for (TreeNode node : nodes) {
            if (node.left != null) {
                childNodes.add(node.left);
            }
            if (node.right != null) {
                childNodes.add(node.right);
            }
        }
        for (TreeNode node : nodes) {
            if (!childNodes.contains(node)) {
                return node; // This node is the root
            }
        }
        return null;
    }

    public static TreeNode findRootUsingCounting(List<TreeNode> nodes) {
        // HashMap to memoize the node counts
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        // Iterate through all nodes
        for (TreeNode node : nodes) {
            // Count the total number of nodes under the current node using memoization
            int nodeCount = getNodeCount(node, memo);
            // If the count matches the size of the input list, this is the root
            if (nodeCount == nodes.size()) {
                return node;
            }
        }
        return null;
    }

    // Helper method to count all nodes in the subtree rooted at the given node with memoization
    public static int getNodeCount(TreeNode node, HashMap<TreeNode, Integer> memo) {
        if (node == null) {         // Base case: null node has 0 nodes
            return 0;
        }
        // Check if the count for this node is already calculated
        if (memo.containsKey(node)) {
            return memo.get(node);
        }
        // Recursively count left and right subtrees, plus 1 for the current node
        int count = getNodeCount(node.left, memo) + getNodeCount(node.right, memo) + 1;
        // Store the calculated count in the memo table
        memo.put(node, count);
        return count;
    }
}

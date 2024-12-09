package Coding.Tree.BinaryTree.DP;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/binary-tree-maximum-path-sum
// 124. Binary Tree Maximum Path Sum
public class MaximumPathSum {
    private int globalMaxSum = Integer.MIN_VALUE; // Tracks the maximum path sum globally

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        calculatePathSum(root);
        return globalMaxSum;
    }

    private int calculatePathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // Recursively calculate the maximum path sum of the left and right subtrees
        int leftSubtreeSum = calculatePathSum(node.left);
        int rightSubtreeSum = calculatePathSum(node.right);

        // Possible maximum path sums involving the current node
        int pathThroughNode = node.val; // Only the current node
        int pathIncludingBothSubtrees = node.val + leftSubtreeSum + rightSubtreeSum; // Current node and both subtrees
        int pathIncludingOneSubtree = Math.max(leftSubtreeSum, rightSubtreeSum) + node.val; // Current node and one subtree

        // Update the global maximum path sum
        globalMaxSum = Math.max(globalMaxSum, pathThroughNode);
        globalMaxSum = Math.max(globalMaxSum, pathIncludingBothSubtrees);
        globalMaxSum = Math.max(globalMaxSum, pathIncludingOneSubtree);

        // Return the maximum path sum that can be extended to the parent node - we can't use pathIncludingBothSubtrees because it cannot be passed above
        return Math.max(pathThroughNode, pathIncludingOneSubtree);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-10);
        treeNode.left = new TreeNode(-9);
        treeNode.right = new TreeNode(-9);
        treeNode.right.left = new TreeNode(-15);
        treeNode.right.right = new TreeNode(-7);
        int i = new MaximumPathSum().maxPathSum(treeNode);
        System.out.println(i);
    }

}

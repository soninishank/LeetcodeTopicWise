package Coding.Tree.BinaryTree.DP;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/binary-tree-maximum-path-sum
public class MaximumPathSum {
    private int maximumSum = Integer.MIN_VALUE;

    private int maxPathSum(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        maximumSum(treeNode);
        return maximumSum;
    }

    private int maximumSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxGainOnLeftSubTree = Math.max(maximumSum(root.left), 0); // what if left side is negative
        int maxGainOnRightSubTree = Math.max(maximumSum(root.right), 0); // what is right side is negative
        int currentPathSum = root.val + maxGainOnLeftSubTree + maxGainOnRightSubTree; // max at current node
        maximumSum = Math.max(maximumSum, currentPathSum);
        return root.val + Math.max(maxGainOnLeftSubTree, maxGainOnRightSubTree); // we need to return parent current
        // node and either its left child or right child
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

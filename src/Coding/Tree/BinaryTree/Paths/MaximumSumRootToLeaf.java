package Coding.Tree.BinaryTree.Paths;

import Coding.Tree.TreeNode;

// Need to check again
// https://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
public class MaximumSumRootToLeaf {

    int max = Integer.MIN_VALUE;

    private int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxSum(root, 0);
        return max;
    }

    private void getMaxSum(TreeNode root, int currentSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            currentSum += root.val;
            if (currentSum > max) {
                max = currentSum;
            }
            return;
        }
        currentSum += root.val;
        getMaxSum(root.left, currentSum);
        getMaxSum(root.right, currentSum);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(-2);
        tree.right = new TreeNode(7);
        tree.left.left = new TreeNode(8);
        tree.left.right = new TreeNode(-4);
        int sum = new MaximumSumRootToLeaf().maxPathSum(tree);
        System.out.println("Sum of nodes is : " + sum);
    }
}

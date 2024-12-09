package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

// Why Use maxValue and minValue?
// left.maxValue: The largest value in the left subtree. If the root's value is not greater than this, the left subtree violates the BST property.
// right.minValue: The smallest value in the right subtree. If the root's value is not smaller than this, the right subtree violates the BST property.
public class LargestBSTSubtree {

    int maxValue = 0; // Keep track of the largest BST subtree size.

    public int largestBSTSubtree(TreeNode root) {
        calcSize(root);
        return maxValue;
    }

    private Result calcSize(TreeNode root) {
        // Base case: an empty tree is a BST
        if (root == null) {
            return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Result left = calcSize(root.left);
        Result right = calcSize(root.right);

        // Check if the current subtree is a BST
        if (left.isBST && right.isBST && root.val > left.maxValue && root.val < right.minValue) {
            int size = 1 + left.size + right.size; // Size of the current BST
            maxValue = Math.max(maxValue, size);  // Update the global max
            return new Result(true, size, Math.min(root.val, left.minValue), Math.max(root.val, right.maxValue));
        } else {
            return new Result(false, 0, 0, 0); // Not a BST
        }
    }

    // Helper class to store the result of each subtree
    private static class Result {
        boolean isBST; // Is the subtree a BST
        int size;      // Size of the BST
        int minValue;  // Minimum value in the subtree
        int maxValue;  // Maximum value in the subtree

        Result(boolean isBST, int size, int minValue, int maxValue) {
            this.isBST = isBST;
            this.size = size;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(8);

        int i = new LargestBSTSubtree().largestBSTSubtree(treeNode);
        System.out.println(i);
    }
}

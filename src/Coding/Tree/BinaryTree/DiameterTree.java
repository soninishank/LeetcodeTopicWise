package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

// the longest path has to be between two leaf nodes
// 1. It can either pass through root
// 2. It can't pass through root
public class DiameterTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // This will find the max depth going through each node,
        // and update the global maximum to the class member 'max'
        maxDepth(root);

        // Return the global maximum
        return max;
    }

    private int maxDepth(TreeNode root) {
        // Height of null is 0
        if (root == null) {
            return 0;
        }

        // Find height of left and right subTrees
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // New global max is either already reached,
        // or is achieved using this node as the root
        max = Math.max(max, left + right);

        // Return height of tree rooted at this node
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(2);

        int i = new DiameterTree().diameterOfBinaryTree(treeNode);
        System.out.println(i);
    }
}

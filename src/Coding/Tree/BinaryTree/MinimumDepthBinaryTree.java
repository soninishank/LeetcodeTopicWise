package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

public class MinimumDepthBinaryTree {
    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = minDepth(node.left);
        int right = minDepth(node.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(5);
        treeNode.right.right.right.right = new TreeNode(6);
        int i = new MinimumDepthBinaryTree().minDepth(treeNode);
        System.out.println(i);
        System.out.println();
    }
}

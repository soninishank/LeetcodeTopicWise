package Coding.Tree.BinaryTree.Symmetry;

import Coding.Tree.TreeNode;

// TODO - Good question
// https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return checkSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean checkSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return root.val == subRoot.val && checkSame(root.left, subRoot.left) && checkSame(root.right, subRoot.right);
    }
}

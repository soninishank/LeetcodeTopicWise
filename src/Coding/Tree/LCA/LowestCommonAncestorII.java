package Coding.Tree.LCA;

import Coding.Tree.TreeNode;

// If either node p or q does not exist in the tree, return null.
// Hence, we need to know that we have seen two values
// use count variable
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
// 1644. Lowest Common Ancestor of a Binary Tree II
public class LowestCommonAncestorII {
    boolean pFound = false;
    boolean qFound = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode LCA = findLCA(root, p, q);
        if (pFound && qFound) {
            return LCA;
        }
        return null;
    }

    private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (root == p) {
            pFound = true;
            return root;
        }
        if (root == q) {
            qFound = true;
            return root;
        }

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}

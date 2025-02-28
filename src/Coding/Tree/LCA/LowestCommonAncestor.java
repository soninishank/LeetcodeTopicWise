package Coding.Tree.LCA;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// It is guaranteed that both p and q are in the tree.
// A node can be a descendant of itself.
// Find common manager - Amazon Seattle
// TC - O(N)
// SC - O(H) - height of the tree
//      it means - Balanced tree - O(logN)
//                 Skewed Tree - O(N)
//Thus the space complexity is O(H)
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
}

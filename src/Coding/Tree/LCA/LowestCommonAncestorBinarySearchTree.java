package Coding.Tree.LCA;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// LowestCommonAncestorBST
// We start from the root of the BST and use the following logic:
// 1. If both p and q are smaller than the root’s value, it means both nodes are in the left subtree. So, we move left (root = root.left).
// 2. If both p and q are greater than the root’s value, it means both nodes are in the right subtree. So, we move right (root = root.right).
// 3. If one node is on the left and the other is on the right, or if the root itself is either p or q, then the current root is the LCA.
public class LowestCommonAncestorBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base condition
        if (root == null) {
            return null;
        }
        // remember to firstly write this conditions
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}

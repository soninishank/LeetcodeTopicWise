package Tree.LCA;

import Tree.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LCABinarySearchTree {
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        // remember to firstly write this conditions
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorBST(root.left, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorBST(root.right, p, q);
        } else {
            return root;
        }
    }
}

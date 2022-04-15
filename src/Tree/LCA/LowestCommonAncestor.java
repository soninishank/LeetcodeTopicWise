package Tree.LCA;

import Tree.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// It is guaranteed that both p and q are in the tree.
// A node can be a descendant of itself.
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}

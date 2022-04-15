package Tree.LCA;

import Tree.TreeNode;

// If either node p or q does not exist in the tree, return null.
// Hence, we need to know that we have seen two values
// use count variable
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
public class LowestCommonAncestorII {
    int count = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode treeNode = calcLCA(root, p, q);
        if (count == 2) {
            return treeNode;
        }
        return null;
    }

    private TreeNode calcLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = calcLCA(root.left, p, q);
        TreeNode right = calcLCA(root.right, p, q);
        if (root == p || root == q) {
            count++;
            return root;
        }
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}

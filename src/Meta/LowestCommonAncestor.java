package Meta;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestor {

    // https://youtu.be/Oi3_06ultic?si=7uWN7QQB8-9_cOfM
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode leftN = lowestCommonAncestor(root.left, p, q);
        TreeNode rightN = lowestCommonAncestor(root.right, p, q);

        // we found both p and q
        if (leftN != null && rightN != null) {
            return root;
        }
        // because this is when p = 2 and q = 4 than directly return the leftN
        if (leftN != null) {
            return leftN;
        }
        // else return rightN
        return rightN;
    }
}

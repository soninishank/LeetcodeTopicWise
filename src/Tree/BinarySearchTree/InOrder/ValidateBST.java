package Tree.BinarySearchTree.InOrder;

// Validate Binary Search Tree
// https://leetcode.com/problems/validate-binary-search-tree/

import Tree.TreeNode;

public class ValidateBST {
    Integer prev;
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        inOrder(root);
        return flag;
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prev == null) {
            prev = root.val;
        } else if (prev >= root.val) {
            flag = false;
        }
        prev = root.val;
        inOrder(root.right);
    }
}

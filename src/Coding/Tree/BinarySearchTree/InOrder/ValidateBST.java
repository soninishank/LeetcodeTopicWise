package Coding.Tree.BinarySearchTree.InOrder;

import Coding.Tree.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/validate-binary-search-tree/
// Similar like  https://leetcode.com/problems/recover-binary-search-tree/
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
        if (prev != null) {
            if (prev >= root.val) {
                flag = false;
            }
        }
        prev = root.val;
        inOrder(root.right);
    }

    public boolean isValidBSTIterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (previous != null && root.val <= previous.val) {
                return false;
            }
            previous = root;
            root = root.right;
        }
        return true;
    }
}

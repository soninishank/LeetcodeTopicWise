package Coding.Tree.BinarySearchTree.InOrder;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/inorder-successor-in-bst/
public class InOrderSuccessorBST {
    TreeNode result = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        getData(root, p);
        return result;
    }

    void getData(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        getData(root.left, p);
        if (result == null && root.val > p.val) {
            result = root;
            return;
        }
        getData(root.right, p);
    }
}

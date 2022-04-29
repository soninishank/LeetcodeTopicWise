package Coding.Tree.BinarySearchTree.InOrder;

import Coding.Tree.TreeNode;

// Recover Binary Search Coding.Tree
// https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBST {
    TreeNode prev = null;
    TreeNode firstElement = null;
    TreeNode secondElement = null;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root);
        // swapping
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        if (prev != null) {
            if (firstElement == null && prev.val >= root.val) {
                firstElement = prev;
            }
            if (firstElement != null && prev.val >= root.val) {
                secondElement = root; // root because large one is covered up in above
            }
        }
        prev = root;
        inOrderTraversal(root.right);
    }
}

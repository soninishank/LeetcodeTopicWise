package Coding.Tree.BinarySearchTree.Medium;

import Coding.Tree.TreeNode;

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
        // swapping the values
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

// large number - firstElement
// small number - secondElement
// 3,2,1 -> given
// 1,2,3 -> after sorting

// 1,3,2,4 -> given
// 1,2,3,4 -> after sorting

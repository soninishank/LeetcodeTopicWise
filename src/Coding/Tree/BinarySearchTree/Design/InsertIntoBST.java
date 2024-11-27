package Coding.Tree.BinarySearchTree.Design;

import Coding.Tree.TreeNode;

// Property of binary search tree
// value is less than root.val -> left subtree
// value is greater than root.val -> right subtree
// root is null - create a node and return
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);// we are always storing the state
        } else {
            root.left = insertIntoBST(root.left, val); // we are always storing the state
        }
        return root;
    }
}

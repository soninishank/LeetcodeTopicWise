package Coding.Tree.BinarySearchTree.Design;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/delete-node-in-a-bst/
// 1.root element is key
// 2.key lies in the left of root
// 3.key lies in the right of root
// 4.key is a left element - left and right is null
public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        // search in right
        if (key > root.val) {
            root.right = deleteNode(root.right, key); // we are always storing the state - root.right
        } // search in left
        else if (key < root.val) {
            root.left = deleteNode(root.left, key); // we are always storing the state - root.left
        } else {
            // leaf node
            if (root.left == null && root.right == null) {
                root = null;
            } // the node is not a leaf and has a right child
            else if (root.right != null) {
                TreeNode successor = successor(root);
                root.val = successor.val; // set the value , now delete this key - root.val become a new key
                root.right = deleteNode(root.right, root.val); // we are always storing the state - root.right
            } else {
                TreeNode predecessor = predecessor(root);
                root.val = predecessor.val;
                root.left = deleteNode(root.left, root.val);// we are always storing the state - root.left
            }
        }
        return root;
    }

    // root se just small - means left me hoga root ke
    // root.left ke bad you need to go to root.right to get just larger if it is available
    private TreeNode predecessor(TreeNode root) {
        root = root.left;
        while (root != null) {
            root = root.right;
        }
        return root;
    }

    // root se just larger - means right me hoga root ke
    // root.right ke bad you need to go to root.left to get just smaller if it is available
    private TreeNode successor(TreeNode root) {
        root = root.right;
        while (root != null) {
            root = root.left;
        }
        return root;
    }
}

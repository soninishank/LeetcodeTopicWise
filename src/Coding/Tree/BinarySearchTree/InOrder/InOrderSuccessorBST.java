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

//        public TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
//            if (node == null) {
//                return null;
//            }
//
//            // Case 1: Node has a right subtree
//            if (node.right != null) {
//                return findMin(node.right);
//            }
//
//            // Case 2: No right subtree, find the lowest ancestor
//            TreeNode successor = null;
//            while (root != null) {
//                if (node.val < root.val) {
//                    successor = root; // Update successor when going left
//                    root = root.left;
//                } else if (node.val > root.val) {
//                    root = root.right;
//                } else {
//                    break; // Node found
//                }
//            }
//
//            return successor;
//        }
//
//        // Helper function to find the minimum value node
//        private TreeNode findMin(TreeNode node) {
//            while (node.left != null) {
//                node = node.left;
//            }
//            return node;
//        }
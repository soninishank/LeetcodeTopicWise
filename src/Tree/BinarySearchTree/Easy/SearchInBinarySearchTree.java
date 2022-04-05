package Tree.BinarySearchTree.Easy;

import Tree.TreeNode;

// https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}

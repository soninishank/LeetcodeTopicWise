package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/delete-nodes-and-return-forest/
// 1110. Delete Nodes And Return Forest
// https://youtu.be/z-pX53sYwWI?si=qup4VI5NwmID4PLI

public class DeleteNodesAndReturnForest {
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return result;
        }
        HashSet<Integer> hashset = new HashSet<>();
        for (int nodeVal : to_delete) {
            hashset.add(nodeVal);
        }
        deleteHelper(root, hashset, result);
        if (!hashset.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    // we need to do bottom up
    private TreeNode deleteHelper(TreeNode root, HashSet<Integer> hashset, List<TreeNode> result) {
        // Base condition
        if (root == null) {
            return null;
        }
        root.left = deleteHelper(root.left, hashset, result);
        root.right = deleteHelper(root.right, hashset, result);

        if (hashset.contains(root.val)) {
            // check if it has any left subtree, add into the result
            if (root.left != null) {
                result.add(root.left);
            }
            // check if it has any right subtree, add into the result
            if (root.right != null) {
                result.add(root.right);
            }
            root = null; // this is the way to delete
            return root;
        } else {
            return root;
        }
    }
}

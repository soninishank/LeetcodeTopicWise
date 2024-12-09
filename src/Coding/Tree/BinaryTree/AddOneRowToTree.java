package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/add-one-row-to-tree/
// 623. Add One Row to Tree
public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return new TreeNode(val); // return new node if root is null
        }

        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root; // attach the old root to the left of new node
            return node; // return new root
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 1;

        // Traverse the tree level by level
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Traverse each node at the current depth
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Once we reach the level just above the desired depth
                if (currentDepth == depth - 1) {
                    TreeNode leftChild = node.left;
                    TreeNode rightChild = node.right;

                    // Create new nodes with the given value and adjust the tree
                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);
                    node.left.left = leftChild; // connect the left child
                    node.right.right = rightChild; // connect the right child
                }

                // Add the children of the current node to the queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            currentDepth++;
        }

        return root;
    }

}

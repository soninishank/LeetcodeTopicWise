package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/check-completeness-of-a-binary-tree/
// 958. Check the Completeness of a Binary Tree
public class CompleteBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode prevNode = root;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                if (prevNode == null) { // Found a gap
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            prevNode = node;
        }
        return true;
    }

    public static void main(String[] args) {
        CompleteBinaryTree solution = new CompleteBinaryTree();

        // Test case: Non-Complete Binary Tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.right = new TreeNode(5); // Missing node at root2.right.left

        System.out.println(solution.isCompleteTree(root2)); // Output: false
    }
}
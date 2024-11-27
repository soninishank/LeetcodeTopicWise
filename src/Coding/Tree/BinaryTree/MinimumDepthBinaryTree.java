package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 111. Minimum Depth of Binary Tree
// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepthBinaryTree {
    int minValue = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preOrderTraversal(root, 1);
        return minValue;
    }

    private void preOrderTraversal(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            minValue = Math.min(minValue, sum);
        }
        preOrderTraversal(root.left, sum + 1);
        preOrderTraversal(root.right, sum + 1);
    }

    // minDepthIterative is very easy
    public int minDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return count;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(5);
        treeNode.right.right.right.right = new TreeNode(6);
        int i = new MinimumDepthBinaryTree().minDepth(treeNode);
        System.out.println(i);
        System.out.println();
    }
}

package Coding.Tree.BinarySearchTree.InOrder;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/closest-binary-search-tree-value/
// 270. Closest Binary Search Tree Value
public class ClosestBinarySearchTreeValue {
    int closestValue = Integer.MIN_VALUE;
    double diff = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        inOrder(root, target);
        return closestValue;
    }

    private void inOrder(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        inOrder(root.left, target);
        if (Math.abs(target - root.val) < diff) {
            diff = Math.abs(target - root.val);
            closestValue = root.val;
        }
        inOrder(root.right, target);
    }

    // Optimized
    public int closestValueOptimized(TreeNode root, double target) {
        TreeNode current = root;
        int closestValue = root.val;

        while (current != null) {
            double currentDiff = Math.abs(target - current.val);
            double closestDiff = Math.abs(target - closestValue);

            // Update the closest if cur is closer or equally close but smaller
            if (currentDiff < closestDiff || (currentDiff == closestDiff && current.val < closestValue)) {
                closestValue = current.val;
            }

            // Move left or right based on target comparison
            if (target < current.val) {
                current = current.left;
            } else if (target > current.val) {
                current = current.right;
            } else {
                // Exact match found
                return current.val;
            }
        }
        return closestValue;
    }
}

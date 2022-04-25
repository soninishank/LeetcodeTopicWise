package Tree.BinarySearchTree.InOrder;

import Tree.TreeNode;

// https://leetcode.com/problems/minimum-distance-between-bst-nodes/
public class MinimumDistanceBetweenBSTNodes {
    Integer prev = null;
    int minDistance = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inOrder(root);
        return minDistance;
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prev == null) {
            prev = root.val;
        } else {
            minDistance = Math.min(minDistance, root.val - prev);
            prev = root.val;
        }
        inOrder(root.right);
    }
}

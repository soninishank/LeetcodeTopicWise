package Tree.BinarySearchTree.Easy;

import Tree.TreeNode;

public class MinAbsoluteDifference {
    Integer prev = null;
    int diff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        calMinDiff(root);
        return diff;
    }

    void calMinDiff(TreeNode root) {
        if (root == null) {
            return;
        }
        calMinDiff(root.left);
        if (prev == null) {
            prev = root.val;
        } else if (diff > Math.abs(root.val - prev)) {
            diff = Math.abs(root.val - prev);
        }
        prev = root.val;
        calMinDiff(root.right);
    }
}

package Tree.BinarySearchTree.Easy;

import Tree.TreeNode;

public class RangeSumBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        rangeSumBST(root.left, low, high);
        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }
        rangeSumBST(root.right, low, high);
        return sum;
    }

    public int rangeSumBSTRange(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }
        if (low <= root.val) {
            rangeSumBSTRange(root.left, low, high);
        }
        if (root.val <= high) {
            rangeSumBSTRange(root.right, low, high);
        }
        return sum;
    }
}

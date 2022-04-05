package Tree.BinarySearchTree.Easy;

import Tree.TreeNode;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructTree(nums, 0, nums.length - 1);
    }

    TreeNode constructTree(int[] nums, int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            return null;
        }
        int mid = lowerBound + (upperBound - lowerBound) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructTree(nums, lowerBound, mid - 1);
        node.right = constructTree(nums, mid + 1, upperBound);
        return node;
    }
}

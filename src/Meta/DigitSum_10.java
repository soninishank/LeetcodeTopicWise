package Meta;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class DigitSum_10 {
    public int sumNumbers(TreeNode root) {
        return sumBuilder(root, 0);
    }

    private int sumBuilder(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }
        currentSum = currentSum * 10 + root.val; // Update the current path sum
        if (root.left == null && root.right == null) {
            return currentSum; // Leaf node, return the sum for this path
        }
        // Recurse for left and right subtrees
        return sumBuilder(root.left, currentSum) + sumBuilder(root.right, currentSum);
    }
}

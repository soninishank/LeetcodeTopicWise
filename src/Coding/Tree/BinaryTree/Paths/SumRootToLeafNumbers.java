package Coding.Tree.BinaryTree.Paths;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRootToLeafNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumBuilder(root, new StringBuilder());
        return sum;
    }

    private void sumBuilder(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }
        stringBuilder.append(root.val);
        if (root.left == null && root.right == null) {
            int val = Integer.parseInt(stringBuilder.toString());
            sum += val;
        } else {
            sumBuilder(root.left, stringBuilder);
            sumBuilder(root.right, stringBuilder);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}

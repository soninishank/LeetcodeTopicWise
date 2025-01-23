package Coding.Amazon.DSA;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/construct-binary-tree-from-string/
// 536. Construct Binary Tree from String
public class _15_ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s.length() == 0) {
            return null;
        }
        return buildTree(s, new int[]{0});
    }

    private TreeNode buildTree(String str, int[] index) {
        if (str.length() == 0) {
            return null;
        }
        if (index[0] > str.length() - 1) {
            return null;
        }
        int start = index[0];
        while (index[0] < str.length()) {
            if (str.charAt(index[0]) == '-') {
                index[0]++;
            } else if (Character.isDigit(str.charAt(index[0]))) {
                index[0]++;
            } else {
                break;
            }
        }
        String substring = str.substring(start, index[0]);
        TreeNode treeNode = new TreeNode(Integer.valueOf(substring));
        if (index[0] < str.length() && str.charAt(index[0]) == '(') {
            index[0]++;
            treeNode.left = buildTree(str, index);
            index[0]++;
        }
        if (index[0] < str.length() && str.charAt(index[0]) == '(') {
            index[0]++;
            treeNode.right = buildTree(str, index);
            index[0]++;
        }
        return treeNode;
    }

    public static void main(String[] args) {
        _15_ConstructBinaryTreeFromString treeNode = new _15_ConstructBinaryTreeFromString();
        String s1 = "4(2(3)(1))(6(5))";
        TreeNode treeNode1 = treeNode.str2tree(s1);

    }
}

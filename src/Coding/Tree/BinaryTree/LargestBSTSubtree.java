package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LargestBSTSubtree {

    boolean flag = true;
    List<Integer> list = new ArrayList<>();
    int max = Integer.MIN_VALUE;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        list = new ArrayList<>();
        checkBST(root);
        max = Math.max(max, list.size());
        largestBSTSubtree(root.left);
        largestBSTSubtree(root.right);
        return max;
    }

    private void checkBST(TreeNode root) {
        if (root == null) {
            return;
        }
        checkBST(root.left);
        list.add(root.val);
        checkBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(8);

        int i = new LargestBSTSubtree().largestBSTSubtree(treeNode);
        System.out.println(i);
    }
}

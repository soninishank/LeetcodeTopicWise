package Coding.Tree.BinarySearchTree.InOrder;

import Coding.Tree.TreeNode;

public class KthSmallest {
    Integer result = null;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        getDataByRecursive(root, k);
        return result;
    }

    void getDataByRecursive(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        getDataByRecursive(root.left, k);
        count++; // count is needed because in recursion your k value is constant,you get different result
        if (k == count) {
            result = root.val;
            return;
        }
        getDataByRecursive(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        treeNode.right = new TreeNode(4);

        int i = new KthSmallest().kthSmallest(treeNode, 1);
        System.out.println(i);
    }
}

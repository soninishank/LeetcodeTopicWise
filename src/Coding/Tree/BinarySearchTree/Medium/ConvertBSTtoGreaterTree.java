package Coding.Tree.BinarySearchTree.Medium;

import Coding.Tree.TreeNode;


// https://www.geeksforgeeks.org/transform-bst-sum-tree/
public class ConvertBSTtoGreaterTree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum - root.val;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(11);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(29);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(40);
        treeNode.right.right.left = new TreeNode(35);


        TreeNode treeNode1 = new ConvertBSTtoGreaterTree().convertBST(treeNode);
        System.out.println(treeNode1);
    }
}

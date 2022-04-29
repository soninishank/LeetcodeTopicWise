package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

public class MergeBinaryTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            TreeNode node = new TreeNode(root2.val);
            return node;
        } else if (root2 == null && root1 != null) {
            return root1;
        } else {
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);


        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        treeNode1.right.right = new TreeNode(3);

        TreeNode treeNode2 = new MergeBinaryTree().mergeTrees(treeNode, treeNode1);
        System.out.println(treeNode2);
    }
}

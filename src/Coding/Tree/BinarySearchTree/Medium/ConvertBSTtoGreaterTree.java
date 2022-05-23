package Coding.Tree.BinarySearchTree.Medium;

import Coding.Tree.TreeNode;


public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
      if (root == null){
          return null;
      }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(6);

        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);

        treeNode.right.right.right = new TreeNode(8);


        treeNode.left.right.right = new TreeNode(3);

        TreeNode treeNode1 = new ConvertBSTtoGreaterTree().convertBST(treeNode);
        System.out.println(treeNode1);
    }
}

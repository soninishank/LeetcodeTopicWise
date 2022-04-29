package Coding.Tree.BinaryTree.Paths;


import Coding.Tree.TreeNode;

// Root to leaf path - check weather the path contains the target value or not
// we are not taking any extra variable like currentSum because it will fail for negative scenarios
// https://leetcode.com/problems/path-sum/
public class PathSum {

    boolean isFlag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        preOrderTraversalSumCheck(root, targetSum);
        return isFlag;
    }

    private void preOrderTraversalSumCheck(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        if (0 == targetSum && root.left == null && root.right == null) {
            isFlag = true;
            return;
        }
        preOrderTraversalSumCheck(root.left, targetSum);
        preOrderTraversalSumCheck(root.right, targetSum);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-2);
        treeNode.right = new TreeNode(-3);


        boolean b = new PathSum().hasPathSum(treeNode, -5);
        System.out.println(b);
    }
}

package Tree.BinaryTree.Paths;

import Tree.TreeNode;

// passing extra information is important
// good question
// https://leetcode.com/problems/sum-of-left-leaves/

public class SumLeftLeaves {

    int total = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return preOrder(root, false);
    }

    int preOrder(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (isLeft == true) {
                return root.val;
            } else {
                return 0;
            }
        } else {
            int left = preOrder(root.left, true);
            int right = preOrder(root.right, false);
            return left + right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);

        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);


        int i = new SumLeftLeaves().sumOfLeftLeaves(treeNode);
        System.out.println(i);
    }

}

package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 0) {
                sum = 0;
            } else {
                return sum;
            }
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    sum = poll.left.val;
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    sum += poll.right.val;
                    queue.add(poll.right);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();
        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);

        treeNode.left.left.left = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(8);

        int i = deepestLeavesSum.deepestLeavesSum(treeNode);
        System.out.println(i);
    }
}

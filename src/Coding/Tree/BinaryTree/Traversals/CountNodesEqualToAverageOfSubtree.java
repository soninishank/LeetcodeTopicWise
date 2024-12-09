package Coding.Tree.BinaryTree.Traversals;

import Coding.Tree.TreeNode;

// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
// 2265. Count Nodes Equal to Average of Subtree
public class CountNodesEqualToAverageOfSubtree {
    int globalCount = 0;

    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findAverage(root);
        return globalCount;
    }

    private Pair findAverage(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair leftPair = findAverage(root.left);
        Pair rightPair = findAverage(root.right);

        int currentSum = root.val + leftPair.sum + rightPair.sum;
        int currentCount = 1 + leftPair.count + rightPair.count;

        int average = currentSum / currentCount;
        if (average == root.val) {
            globalCount++;
        }
        return new Pair(currentSum, currentCount);
    }

    class Pair {
        int sum;
        int count;

        public Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
}

package Coding.Tree.BinaryTree.Views;

import Coding.Tree.TreeNode;

import java.util.*;

// 314. Binary Tree Vertical Order Traversal
// https://leetcode.com/problems/binary-tree-vertical-order-traversal/
public class BinaryTreeVerticalOrderTraversal {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        Queue<RowColDirection> queue = new LinkedList<>();
        queue.add(new RowColDirection(0, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                RowColDirection poll = queue.poll();
                if (treeMap.containsKey(poll.col)) {
                    treeMap.get(poll.col).add(poll.treeNode.val);
                } else {
                    treeMap.put(poll.col, new ArrayList<>());
                    treeMap.get(poll.col).add(poll.treeNode.val);
                }
                if (poll.treeNode.left != null) {
                    queue.add(new RowColDirection(poll.col - 1, poll.treeNode.left));
                }
                if (poll.treeNode.right != null) {
                    queue.add(new RowColDirection(poll.col + 1, poll.treeNode.right));
                }
            }
        }
        for (int key : treeMap.keySet()) {
            result.add(treeMap.get(key));
        }
        return result;
    }
}

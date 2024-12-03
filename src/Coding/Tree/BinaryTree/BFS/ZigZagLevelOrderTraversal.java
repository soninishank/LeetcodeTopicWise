package Coding.Tree.BinaryTree.BFS;

import Coding.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// 103. Binary Tree Zigzag Level Order Traversal
public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zigzag = false;

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pollVal = queue.poll();
                if (pollVal.left != null) {
                    queue.add(pollVal.left);
                }
                if (pollVal.right != null) {
                    queue.add(pollVal.right);
                }
                if (!zigzag) {
                    list.add(pollVal.val);
                } else {
                    list.add(0, pollVal.val);
                }
            }
            zigzag = !zigzag;
            result.add(list);
        }
        return result;
    }
}

package Coding.Tree.BinaryTree.Views;

import Coding.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22
 */
// https://leetcode.com/problems/binary-tree-right-side-view/
public class RightView {
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideViewUsingBFS(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == size - 1) {
                    result.add(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return result;
    }

    public List<Integer> rightSideViewUsingDFS(TreeNode root) {
        if (root == null) {
            return result;
        }
        preOrderTraversal(root, 1, result);
        return result;
    }

    private void preOrderTraversal(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() < level) {
            result.add(root.val);
        }
        preOrderTraversal(root.right, level + 1, result);
        preOrderTraversal(root.left, level + 1, result);
    }

}

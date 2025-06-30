package Meta;

import Coding.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/check-completeness-of-a-binary-tree/
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTreeUsingBFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode prev = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                if (prev == null) {
                    return false;
                }
                queue.add(poll.left);
                queue.add(poll.right);

                prev = poll;
            }
        }
        return true;
    }

    // https://youtu.be/5zyG8Nw9V78?si=cQlQqqtpQBXA5587
    public boolean isCompleteTreeUsingDFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        int totalNodes = countTotalNodes(root);
        return applyDfs(root, 1, totalNodes); // we will start from 1
    }

    private boolean applyDfs(TreeNode root, int index, int totalNodes) {
        if (root == null) {
            return true;
        }
        if (index > totalNodes) {
            return false;
        }
        return applyDfs(root.left, 2 * index, totalNodes) && applyDfs(root.right, 2 * index + 1, totalNodes);
    }

    private int countTotalNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countTotalNodes(root.left) + countTotalNodes(root.right);
    }
}

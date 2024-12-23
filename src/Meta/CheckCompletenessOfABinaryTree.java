package Meta;

import Coding.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/check-completeness-of-a-binary-tree/
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
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
}

package Meta;

import Coding.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Print both left and right side view
// You need to ask whether to print root node one time or two time
public class BinaryTreeLeftAndRightSideView_5 {
    // Combined function to compute both left and right views
    public void computeLeftAndRightSideViews(TreeNode root, boolean printRootOnce) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        List<Integer> leftView = new ArrayList<>();
        List<Integer> rightView = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // First node at the level goes to the left view
                if (i == 0) {
                    leftView.add(node.val);
                }
                // Last node at the level goes to the right view
                if (i == size - 1) {
                    rightView.add(node.val);
                }

                // Add child nodes to the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        // Handle root printing logic
        if (printRootOnce && !rightView.isEmpty()) {
            rightView.remove(0); // Remove root from the right view
        }

        // Print the results
        System.out.println("Left Side View: " + leftView);
        System.out.println("Right Side View: " + rightView);
    }

    public static void main(String[] args) {
        BinaryTreeLeftAndRightSideView_5 tree = new BinaryTreeLeftAndRightSideView_5();

        // Example tree:
        //          1
        //         / \
        //        2   3
        //       / \   \
        //      4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Print left and right side views
        tree.computeLeftAndRightSideViews(root, true); // Root printed once
        tree.computeLeftAndRightSideViews(root, false); // Root printed in both views
    }
}

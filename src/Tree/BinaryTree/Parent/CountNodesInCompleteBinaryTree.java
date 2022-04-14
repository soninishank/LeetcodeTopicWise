package Tree.BinaryTree.Parent;

import Tree.TreeNode;

// https://leetcode.com/problems/count-complete-tree-nodes/
public class CountNodesInCompleteBinaryTree {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = countLeftHeight(root);
        int rightHeight = countRightHeight(root);
        if (leftHeight == rightHeight) {
            return (int) (Math.pow(2, leftHeight) - 1);
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right); // 1 we are adding for root
        }
    }

    private int countLeftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        while (root != null) {
            root = root.left;
            count++;
        }
        return count;
    }

    private int countRightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        while (root != null) {
            root = root.right;
            count++;
        }
        return count;
    }
}

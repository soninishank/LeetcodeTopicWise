package Tree.BinaryTree.Symmetry;

import Tree.TreeNode;

// https://leetcode.com/problems/symmetric-tree/
// https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && checkSymmetric(root1.left, root2.right) && checkSymmetric(root1.right, root2.left);
    }

    public static void main(String[] args) {

    }
}

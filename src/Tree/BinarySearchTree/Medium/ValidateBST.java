package Tree.BinarySearchTree.Medium;

import Tree.TreeNode;

// https://leetcode.com/problems/validate-binary-search-tree/
// Similar like  https://leetcode.com/problems/recover-binary-search-tree/
public class ValidateBST {
    Integer prev;
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        inOrder(root);
        return flag;
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prev != null) {
            if (prev >= root.val) {
                flag = false;
            }
        }
        prev = root.val;
        inOrder(root.right);
    }
}

package Tree.BinarySearchTree.InOrder;

import Tree.TreeNode;

public class InOrderSuccessorBST {
    TreeNode result = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        getData(root, p);
        return result;
    }

    void getData(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        inorderSuccessor(root.left, p);
        if (result == null && root.val > p.val) {
            result = root;
            return;
        }
        inorderSuccessor(root.right, p);
    }
}

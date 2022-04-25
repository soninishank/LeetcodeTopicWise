package Tree.BinarySearchTree.InOrder;

import Tree.TreeNode;

// Just like successor only
// https://leetcode.com/discuss/interview-question/542842/facebook-phone-powx-n-inorder-predecessor-in-bst
public class InOrderPredecessorBST {

    TreeNode result = null;
    TreeNode prev = null;

    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        getPredecessor(root, p);
        return result;
    }

    void getPredecessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        getPredecessor(root.left, p);
        if (root.val == p.val && p.val > prev.val) {
            result = prev;
            return;
        }
        if (prev == null) {
            prev = root;
        } else {
            prev = root;
        }
        getPredecessor(root.right, p);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);

        TreeNode treeNode1 = new InOrderPredecessorBST().inorderPredecessor(treeNode, treeNode.right);
        System.out.println(treeNode1.val);
    }
}

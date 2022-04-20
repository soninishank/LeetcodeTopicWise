package Tree.BinaryTree.Symmetry;

import Tree.TreeNode;

// https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = invertTree(root.left);// just saving left tree
        root.left = invertTree(root.right);  // assigning right tree to left
        root.right = temp;// then left to right
        return root;// returning root
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        TreeNode treeNode1 = new InvertBinaryTree().invertTree(treeNode);

    }
}

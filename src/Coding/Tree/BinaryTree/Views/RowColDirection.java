package Coding.Tree.BinaryTree.Views;

import Coding.Tree.TreeNode;

public class RowColDirection {
    int col;
    TreeNode treeNode;
    int row;

    public RowColDirection(int col, TreeNode treeNode) {
        this.col = col;
        this.treeNode = treeNode;
    }

    public RowColDirection(int row, int col, TreeNode treeNode) {
        this.row = row;
        this.col = col;
        this.treeNode = treeNode;
    }
}

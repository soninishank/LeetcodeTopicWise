package Coding.Tree.BinaryTree.Views;

import Coding.Tree.TreeNode;

public class TreeNodeInfo {
    int row;
    int column;
    TreeNode treeNode;

    public TreeNodeInfo(int row, int column, TreeNode treeNode) {
        this.row = row;
        this.column = column;
        this.treeNode = treeNode;
    }

    public TreeNodeInfo(int col, TreeNode treeNode) {
        this.column = col;
        this.treeNode = treeNode;
    }
}


package Coding.Tree.BinaryTree.Views;

import Coding.Tree.TreeNode;

public class TreeNodeInfo {
    int row;
    int column;
    TreeNode node;

    public TreeNodeInfo(int row, int column, TreeNode node) {
        this.row = row;
        this.column = column;
        this.node = node;
    }

    public TreeNodeInfo(int col, TreeNode treeNode) {
        this.column = col;
        this.node = treeNode;
    }
}


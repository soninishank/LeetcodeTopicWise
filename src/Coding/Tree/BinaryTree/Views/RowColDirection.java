package Coding.Tree.BinaryTree.Views;

import Coding.Tree.TreeNode;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22
 */
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

package Tree.BinaryTree.Views;

import Tree.TreeNode;

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

    public RowColDirection(int col, int row, TreeNode treeNode) {
        this.col = col;
        this.treeNode = treeNode;
        this.row = row;
    }
}

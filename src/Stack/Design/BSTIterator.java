package Stack.Design;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/binary-search-tree-iterator/
public class BSTIterator {

    Queue<Integer> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        inOrderTraversal(root);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return queue.size() > 0;
    }


    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        queue.add(root.val);
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(20);
        BSTIterator bSTIterator = new BSTIterator(treeNode);
    }
}

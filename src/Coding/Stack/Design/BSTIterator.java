package Coding.Stack.Design;

import Coding.Tree.TreeNode;

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

// This is an optimized approach
//class BSTIterator {
//    Stack<Node> stack;
//    TreeNode node;
//
//    public BSTIterator(TreeNode root) {
//        node = root;
//        stack = new Stack<>();
//        while (root != null) {
//            stack.push(root);
//            root = root.left;
//        }
//    }
//
//    public int next() {
//        TreeNode currentElement = stack.pop();
//        int val = currentElement.val;
//        currentElement = currentElement.right; // only go to one time right
//
//        // than again process all its left
//        while (currentElement != null) {
//            stack.push(currentElement);
//            currentElement = currentElement.left;
//        }
//        return val;
//    }
//
//    public boolean hasNext() {
//        return stack.isEmpty();
//    }
//}
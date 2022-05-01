package Coding.Stack.Design;

import Coding.Tree.TreeNode;

import java.util.Stack;

public class BSTIteratorFollowUp {
    Stack<TreeNode> stack;
    TreeNode current;

    public BSTIteratorFollowUp(TreeNode root) {
        this.stack = new Stack<>();
        this.current = root;
    }

    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop(); // O(1)
        int result = current.val;
        current = current.right;
        return result;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }
}

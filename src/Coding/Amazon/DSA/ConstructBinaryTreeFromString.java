package Coding.Amazon.DSA;

import Coding.Tree.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/construct-binary-tree-from-string/
public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null; // Return null if the string is empty
        }

        Stack<TreeNode> stack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                // Move to the next character
                i++;
            } else if (c == ')') {
                // Finished with the current node, pop from the stack
                stack.pop();
                i++;
            } else {
                // Parse the number (could be negative or multi-digit)
                int start = i;
                // s.charAt(i) == '-', it means a number can be negative also
                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-')) {
                    i++;
                }
                int num = Integer.parseInt(s.substring(start, i));
                TreeNode node = new TreeNode(num);
                // If the stack is not empty, connect the node to its parent
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) {
                        parent.left = node; // Add as left child if it's empty
                    } else {
                        parent.right = node; // Otherwise, add as right child
                    }
                }
                // Push the current node to the stack
                stack.push(node);
            }
        }

        // The root of the tree is the last remaining node in the stack
        return stack.isEmpty() ? null : stack.peek();
    }
}

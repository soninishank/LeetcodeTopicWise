package Meta;

import Coding.Tree.TreeNode;

public class ParentTreeFinder {
    public static TreeNode findParent(TreeNode root, TreeNode targetNode) {
        // Base cases: if root is null or targetNode is null, or if the root itself is the target
        if (root == null || targetNode == null || root == targetNode) {
            return null; // Root has no parent
        }

        // Use the helper function to find the parent
        return findParentHelper(root, targetNode);
    }

    private static TreeNode findParentHelper(TreeNode currentNode, TreeNode targetNode) {
        if (currentNode == null) {
            return null; // No parent found in this path
        }

        // Check if the targetNode is a direct child of the currentNode
        TreeNode child = currentNode.left; // Start with the first child
        while (child != null) { // Iterate through all siblings
            if (child == targetNode) {
                return currentNode; // Parent found
            }
            child = child.right; // Move to the next sibling
        }

        // Recursively check in the subtrees of the currentNode's children
        child = currentNode.left; // Reset to the first child
        while (child != null) {
            TreeNode parentFound = findParentHelper(child, targetNode);
            if (parentFound != null) {
                return parentFound; // Parent found in the subtree
            }
            child = child.right; // Move to the next sibling
        }

        return null; // No parent found
    }

}

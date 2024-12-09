package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

import java.util.*;

// https://leetcode.com/problems/delete-nodes-and-return-forest/
// 1110. Delete Nodes And Return Forest
// https://youtu.be/z-pX53sYwWI?si=qup4VI5NwmID4PLI

public class DeleteNodesAndReturnForest {
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return result;
        }
        HashSet<Integer> hashset = new HashSet<>();
        for (int nodeVal : to_delete) {
            hashset.add(nodeVal);
        }
        deleteHelper(root, hashset, result);
        if (!hashset.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    // we need to do bottom up
    private TreeNode deleteHelper(TreeNode root, HashSet<Integer> hashset, List<TreeNode> result) {
        // Base condition
        if (root == null) {
            return null;
        }
        root.left = deleteHelper(root.left, hashset, result);
        root.right = deleteHelper(root.right, hashset, result);

        if (hashset.contains(root.val)) {
            // check if it has any left subtree, add into the result
            if (root.left != null) {
                result.add(root.left);
            }
            // check if it has any right subtree, add into the result
            if (root.right != null) {
                result.add(root.right);
            }
            root = null; // this is the way to delete
            return root;
        } else {
            return root;
        }
    }

    // It is very simple
    // 1. While traversing itself, we will mark it as null
    // 2. toDeleteSet.contains(currentNode.val) -> this will take care of left and child elements
    public List<TreeNode> delNodesUsingBFS(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }

        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        List<TreeNode> forest = new ArrayList<>();

        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        while (!nodesQueue.isEmpty()) {
            TreeNode currentNode = nodesQueue.poll();

            if (currentNode.left != null) {
                nodesQueue.add(currentNode.left);
                // Disconnect the left child if it needs to be deleted
                if (toDeleteSet.contains(currentNode.left.val)) {
                    currentNode.left = null;
                }
            }

            if (currentNode.right != null) {
                nodesQueue.add(currentNode.right);
                // Disconnect the right child if it needs to be deleted
                if (toDeleteSet.contains(currentNode.right.val)) {
                    currentNode.right = null;
                }
            }

            // If the current node needs to be deleted, add its non-null children to the forest
            if (toDeleteSet.contains(currentNode.val)) {
                if (currentNode.left != null) {
                    forest.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    forest.add(currentNode.right);
                }
            }
        }

        // Ensure the root is added to the forest if it is not to be deleted
        if (!toDeleteSet.contains(root.val)) {
            forest.add(root);
        }
        return forest;
    }

    public static void main(String[] args) {
        int[] delete = {3, 5};
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);


        List<TreeNode> treeNodeList = new DeleteNodesAndReturnForest().delNodesUsingBFS(node, delete);
        System.out.println(treeNodeList);
    }
}

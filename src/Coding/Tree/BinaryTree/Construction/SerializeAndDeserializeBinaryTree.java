package Coding.Tree.BinaryTree.Construction;

import Coding.Tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// easy way - serialization - just append string to a string builder and add comma , for null add #
// deserialization - just use deque - split by comma - add all in queue then build tree
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        preOrderTraversal(root, stringBuilder);
        return stringBuilder.toString();
    }

    private String preOrderTraversal(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return stringBuilder.append("null").append(",").toString();
        }
        stringBuilder.append(root.val).append(",");
        preOrderTraversal(root.left, stringBuilder);
        preOrderTraversal(root.right, stringBuilder);
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        String[] split = data.split(",");
        queue.addAll(Arrays.asList(split));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        if (!queue.isEmpty()) {
            String poll = queue.poll();
            if (poll.equals("#")) { // Do remember to use equals method
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(poll));
                node.left = buildTree(queue);
                node.right = buildTree(queue);
                return node;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);

        String serialize = new SerializeAndDeserializeBinaryTree().serialize(treeNode);
        new SerializeAndDeserializeBinaryTree().deserialize(serialize);
        System.out.printf(serialize);
    }
}

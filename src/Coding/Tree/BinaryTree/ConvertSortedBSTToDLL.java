package Coding.Tree.BinaryTree;

// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
public class ConvertSortedBSTToDLL {
    Node prev = null;
    Node headLinkedList = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        return headLinkedList;
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prev == null) {
            headLinkedList = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        ConvertSortedBSTToDLL convertSortedBSTToDLL = new ConvertSortedBSTToDLL();
        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(5);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        Node node1 = convertSortedBSTToDLL.treeToDoublyList(node);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.right;
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

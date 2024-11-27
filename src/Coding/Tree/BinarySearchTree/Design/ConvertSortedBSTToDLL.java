package Coding.Tree.BinarySearchTree.Design;

// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
// same code will work for Binary Tree to DLL
// 426. Convert Binary Search Tree to Sorted Doubly Linked List
public class ConvertSortedBSTToDLL {
    Node head;
    Node tail;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);

        // Now make it circular
        head.left = tail;
        tail.right = head;

        return head;
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (head == null) {
            head = root;
        } else {
            root.left = tail;
            tail.right = root;
        }
        tail = root; // moving current
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
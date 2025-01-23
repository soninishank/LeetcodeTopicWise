package Coding.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
// 116. Populating Next Right Pointers in Each Node
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public Node connectUsingBFS(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left != null) {
                poll.left.next = poll.right;
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                if (poll.next != null) {
                    poll.right.next = poll.next.left;
                }
            }
        }
        return root;
    }

    public void connectWithoutExtraSpace(Node root) {
        if (root == null) {
            return;
        }
        // Start with the root node
        Node current = root;
        while (current != null) {
            Node dummy = new Node(0); // Dummy node to track the start of the next level
            Node tail = dummy; // Tail pointer to connect nodes at the next level
            // Traverse the current level
            while (current != null) {
                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }
                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }
                current = current.next; // Move to the next node at the current level
            }
            // Move to the next level
            current = dummy.next;
        }
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode test = new PopulatingNextRightPointersInEachNode();


    }
}

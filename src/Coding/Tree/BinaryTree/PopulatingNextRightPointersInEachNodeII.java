package Coding.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
// 117. Populating Next Right Pointers in Each Node II
// The only difference between 116 and 117 is that there are some nodes which will be
// missing, meaning nodes may be missing on one side or the other

// Key Insight: Pointers and References in Java
// In Java objects are always accessed by reference. This means that when we assign dummy.next = pollVal, we are not duplicating or copying
// pollVal—we are creating a link (or reference) to the existing object in memory.

// Even after the dummy variable is reassigned or goes out of scope, the references it created (via dummy.next) remain intact because they point directly to the objects
// in memory.

// It's a game of reference
public class PopulatingNextRightPointersInEachNodeII {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // After finishing a level, `dummy` itself is discarded, but the nodes
            // connected through `dummy.next` remain intact.
            Node dummy = new Node(0);
            for (int i = 0; i < size; i++) {
                Node pollVal = queue.poll();
                dummy.next = pollVal;
                dummy = dummy.next;
                if (pollVal.left != null) {
                    queue.add(pollVal.left);
                }
                if (pollVal.right != null) {
                    queue.add(pollVal.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.right.right = new Node(5);

        Node connect = new PopulatingNextRightPointersInEachNodeII().connect(node);
    }


    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            val = val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

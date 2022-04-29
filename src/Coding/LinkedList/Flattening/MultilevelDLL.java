package Coding.LinkedList.Flattening;

import java.util.Stack;

public class MultilevelDLL {
    public Node flatten(Node head) {
        Node temp = head;
        Stack<Node> stack = new Stack<>();
        while (temp != null) {
            if (temp.child != null) {
                // we will push its next to stack
                if (temp.next != null) {
                    stack.push(temp.next);
                }
                // point current next to its child and make the child null
                temp.next = temp.child;
                temp.child = null;
                temp.next.prev = temp;// previous pointer linked
            } else if (temp.next == null && !stack.isEmpty()) {
                temp.next = stack.pop();
                temp.next.prev = temp;// previous pointer
            }
            temp = temp.next;
        }
        return head;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);

        node.next.child = new Node(7);
        node.next.child.next = new Node(8);

        node.next.child.next.child = new Node(11);
        node.next.child.next.child.next = new Node(12);

        node.next.child.next.next = new Node(9);
        node.next.child.next.next.next = new Node(10);

        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);

        new MultilevelDLL().flatten(node);
    }

    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }
}

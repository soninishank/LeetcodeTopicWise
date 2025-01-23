package Coding.LinkedList;

import java.util.HashMap;

// TODO: META
// https://leetcode.com/problems/copy-list-with-random-pointer/
// I have done this exactly the same way as i have done the https://leetcode.com/problems/clone-graph/
// You can paste the same code and modify few things, the code will work
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> visitedNode = new HashMap<>();
        Node current = head;
        // Create a deep copy of each node and store it in the HashMap
        while (current != null) {
            visitedNode.put(current, new Node(current.val, null, null));
            current = current.next;
        }

        // Reset current to the head to update the `next` and `random` pointers
        current = head;
        while (current != null) {
            Node deepNode = visitedNode.get(current);
            deepNode.next = visitedNode.get(current.next);
            deepNode.random = visitedNode.get(current.random);
            current = current.next;
        }
        // Return the deep copy of the head
        return visitedNode.get(head);
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

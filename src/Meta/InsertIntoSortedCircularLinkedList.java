package Meta;

// https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
// List is singly connected, i.e. node has a pointer/reference to the next node, but not to the previous node.
// List is circular, i.e. the last node points to the first node. If there is only one node, it points to itself.
// Any node can be given as a starting node as the list is circular and all nodes can be reached from any node.
// Elements are sorted, except for the point where the biggest element reaches the smallest element.
// Integers may be negative (but this doesn't matter at all and the candidate should realize that).
// Duplicates are allowed (I explicitly ask about this later on if the candidate doesn't ask about it).
// When inserting a value that already exists, i.e., there are multiple valid insertion points, anyone is fine.

public class InsertIntoSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        // Case 1: Empty list, create a self-loop
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node current = head;
        // we will loop untill we reach back again to the head
        while (current.next != head) {
            // Case 2: Insert between two nodes (sorted order)
            if (current.val <= insertVal && insertVal <= current.next.val) {
                break; // break means we insert at that place current location
            }

            // Case 3: Insert at the "wrap-around" point
            // 3 -> 4 -> 1 -> (back to 3)
            // The largest value is 4.The smallest value is 1.The "wrap-around" point is between 4 and
            if (current.val > current.next.val && (insertVal >= current.val || insertVal <= current.next.val)) {
                break; // break means we insert at that place current location
            }

            current = current.next;
        }

        // Insert the new node
        Node newNode = new Node(insertVal, current.next);
        current.next = newNode;

        return head;
    }
}

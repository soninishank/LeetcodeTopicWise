package LinkedList;

import java.util.HashMap;

// https://leetcode.com/problems/copy-list-with-random-pointer/w
public class CopyListWithRandomPointer {
    // O(N) space
    public Node copyRandomListUsingHashMap(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> hashmap = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node Node = new Node(temp.val);
            hashmap.put(temp, Node); // key is old object value is new deep object
            temp = temp.next;
        }
        // Now create a deep copy - consider each and everything as a new object
        temp = head;
        while (temp != null) {
            hashmap.get(temp).next = hashmap.get(temp.next);
            hashmap.get(temp).random = hashmap.get(temp.random);
            temp = temp.next;
        }
        return hashmap.get(head);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        // Step 1 : original :: A-> B  cloning :: A -> A' -> B -> B'
        while (temp != null) {
            // clone node
            Node newNode = new Node(temp.val);
            newNode.next = temp.next; // A' will point to B

            temp.next = newNode; // My current pointer A should point A' - making a link - A -> A' -> B
            temp = newNode.next; // increase temp position by 2x that is go at the B position
        }
        // Step 2 : creating a random pointer
        // Current temp list :: A -> A' -> B -> B'
        // Assume B random is A , therefore B' random is A'
        // Now if you want to find B' random you write like this
        // B'.random = B.random.next; (which is A')
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            } else {
                temp.next.random = null;
            }
            temp = temp.next.next; // reach from A to B
        }
        // Step 3 :: creating a new copy list from the original list
        Node oldPtr = head;
        Node newPtr = head.next;
        Node deepCopyList = head.next;
        while (oldPtr != null) {
            oldPtr.next = oldPtr.next.next;
            if (newPtr.next != null) {
                newPtr.next = newPtr.next.next;
            }
            oldPtr = oldPtr.next;
            newPtr = newPtr.next;
        }
        return deepCopyList;
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

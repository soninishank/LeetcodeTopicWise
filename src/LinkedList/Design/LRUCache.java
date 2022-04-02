package LinkedList.Design;

import java.util.HashMap;

// https://leetcode.com/problems/lru-cache/
public class LRUCache {
    int size;
    Node head, tail;
    HashMap<Integer, Node> hashmap = new HashMap<>();

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.size = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        if (hashmap.containsKey(key)) {
            Node poll = hashmap.get(key);
            remove(poll);
            addHead(poll);
            return poll.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hashmap.containsKey(key)) {
            Node node = hashmap.get(key);
            node.value = value;
            remove(node);
            addHead(node);
        } else {
            if (hashmap.size() == this.size) {
                hashmap.remove(tail.key);
                remove(tail);
            }
            Node node = new Node(key, value);
            hashmap.put(key, node);
            addHead(node);
        }
    }

    void remove(Node node) {
        // Previous Node
        if (node.prev != null) {
            node.prev.next = node.next;
        } else if (node.prev == null) { //Head Node
            head = node.next;
        }
        // Next node
        if (node.next != null) {
            node.next.prev = node.prev;
        } else if (node.next == null) {
            tail = node.prev;
        }
    }

    // We need to set this node as head
    void addHead(Node newNode) {
        /* 1. Make next of new node as head and previous as NULL */
        newNode.prev = null;
        newNode.next = head;
        // 2. Change prev of head node to new node : Means there is already an element
        if (head != null) {
            head.prev = newNode;
        }
        // 3. move the head to point to the new node */
        head = newNode;
        // If the list is empty
        if (tail == null) {
            tail = newNode;
        }
    }
}

/*
// Add node at the front of the list
    public void push(int new_data) {
        1. allocate node
         *2. put in the data
        Node new_Node = new Node(new_data);

        3. Make next of new node as head and previous as NULL
        new_Node.next = head;
        new_Node.prev = null;

        4. change prev of head node to new node
        if (head != null)
            head.prev = new_Node;

        5. move the head to point to the new node
        head = new_Node;
    }
*/

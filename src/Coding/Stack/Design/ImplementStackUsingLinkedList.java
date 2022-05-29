package Coding.Stack.Design;

// https://leetcode.com/discuss/interview-experience/550385/eBay-Software-Engineer-Interview
public class ImplementStackUsingLinkedList {
    Node top;

    ImplementStackUsingLinkedList() {
        this.top = null;
    }

    private void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
    }

    private boolean isEmpty() {
        return top == null;
    }

    private int peek() {
        return top.data;
    }

    private void pop() {
        top = top.next;
    }

    public static void main(String[] args) {
        ImplementStackUsingLinkedList implementStackUsingLinkedList = new ImplementStackUsingLinkedList();
        implementStackUsingLinkedList.push(10);
        implementStackUsingLinkedList.push(20);
        implementStackUsingLinkedList.push(30);
        System.out.println(implementStackUsingLinkedList.peek());
        implementStackUsingLinkedList.pop();
        System.out.println(implementStackUsingLinkedList.peek());
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

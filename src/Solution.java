import java.util.Stack;

class Solution {

    private boolean isValidTree() {
        return false;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(3);
        node.left.right = new Node(4);
        node.left.right.left = new Node(5);
        node.left.right.right = new Node(6);
        node.right = new Node(7);
        node.right.left = new Node(8);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
    }
}
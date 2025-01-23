public class Test {

    public void connect(Node root) {
        if (root == null) return;

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

    public static void main(String[] args) {
        // Example Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        Test solution = new Test();
        solution.connect(root);

        // Output to verify the connections
        Node current = root;
        while (current != null) {
            Node level = current;
            while (level != null) {
                System.out.print(level.val + " -> ");
                level = level.next;
            }
            System.out.println("NULL");
            current = current.left; // Move to the next level
        }
    }
}

class Node {
    int val;
    Node left, right, next;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}
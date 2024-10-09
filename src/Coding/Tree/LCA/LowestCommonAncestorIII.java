package Coding.Tree.LCA;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
// 1650. Lowest Common Ancestor of a Binary Tree III
// Since each node has a parent reference, we can traverse upwards from both p and q until we find a common ancestor.
// This problem is similar to finding the intersection of two linked lists, where the intersection point is the LCA.
public class LowestCommonAncestorIII {
    public Node lowestCommonAncestor(Node parent1, Node parent2) {
        // Edge case 1: One or both nodes are null
        if (parent1 == null || parent2 == null) {
            return null;
        }
        // Edge case 2: If p and q are the same node, return p (or q, since they are the same)
        if (parent1 == parent2) {
            return parent1;
        }
        Node a = parent1, b = parent2;
        while (a != b) {
            if (a == null) {
                a = parent2;
            } else {
                a = a.parent;
            }
            if (b == null) {
                b = parent1;
            } else {
                b = b.parent;
            }
        }
        return a; // you can return anything a or b
    }

    public static void main(String[] args) {
// Create nodes
        Node root = new Node(3);
        Node node5 = new Node(5);
        Node node1 = new Node(1);
        Node node6 = new Node(6);
        Node node2 = new Node(2);
        Node node0 = new Node(0);
        Node node8 = new Node(8);
        Node node7 = new Node(7);
        Node node4 = new Node(4);

        // Set up the tree structure with parent pointers
        root.left = node5;
        root.right = node1;
        node5.parent = root;
        node1.parent = root;

        node5.left = node6;
        node5.right = node2;
        node6.parent = node5;
        node2.parent = node5;

        node1.left = node0;
        node1.right = node8;
        node0.parent = node1;
        node8.parent = node1;

        node2.left = node7;
        node2.right = node4;
        node7.parent = node2;
        node4.parent = node2;

        // Test case: p = 5, q = 1
        Node p = node5;
        Node q = node1;

        LowestCommonAncestorIII lowestCommonAncestorIII = new LowestCommonAncestorIII();
        Node lca = lowestCommonAncestorIII.lowestCommonAncestor(p, q);

        // Test case: p = 5, q = 4
        p = node5;
        q = node4;

        lca = lowestCommonAncestorIII.lowestCommonAncestor(p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        Node(int val) {
            this.val = val;
        }
    }
}

//
//        3
//       / \
//      5   1
//     / \  / \
//    6   2 0  8
//       / \
//      7   4
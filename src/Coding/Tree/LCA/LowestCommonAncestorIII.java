package Coding.Tree.LCA;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
public class LowestCommonAncestorIII {
    public Node lowestCommonAncestor(Node parent1, Node parent2) {
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

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    ;
}

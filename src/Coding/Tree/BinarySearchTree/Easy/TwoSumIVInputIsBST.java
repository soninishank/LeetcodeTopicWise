package Coding.Tree.BinarySearchTree.Easy;

import Coding.Tree.TreeNode;

import java.util.HashSet;

public class TwoSumIVInputIsBST {

    HashSet<Integer> hashset = new HashSet<>();

    // input -> 1 , k = 2
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (hashset.contains(k - root.val)) {
            return true;
        }
        hashset.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        boolean target = new TwoSumIVInputIsBST().findTarget(node, 4);
        System.out.println(target);
    }
}

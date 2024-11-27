package Coding.Tree.BinarySearchTree.InOrder;

import Coding.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/balance-a-binary-search-tree/
public class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return createBST(root, 0, list.size() - 1, list);
    }

    public TreeNode createBST(TreeNode root, int low, int high, List<Integer> list) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = createBST(root, low, mid - 1, list);
        node.right = createBST(root, mid + 1, high, list);
        return node;
    }


    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}

package Coding.Tree.BinarySearchTree.Design;

import Coding.LinkedList.ListNode;
import Coding.Tree.TreeNode;

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
// 109. Convert Sorted List to Binary Search Tree
public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode head, ListNode tail) {
        // Base case: if head equals tail, return null (no subtree)
        // means there is only one element left so you can't form a tree
        if (head == tail) {
            return null;
        }

        // Find the middle of the list using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now at the middle of the list
        TreeNode root = new TreeNode(slow.val);

        // Recursively construct the left and right subtrees
        root.left = buildTree(head, slow); // Left subtree from head to slow
        root.right = buildTree(slow.next, tail); // Right subtree from slow.next to tail

        return root;
    }
}

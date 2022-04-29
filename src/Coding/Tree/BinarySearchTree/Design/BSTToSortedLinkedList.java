package Coding.Tree.BinarySearchTree.Design;

import Coding.LinkedList.ListNode;
import Coding.Tree.TreeNode;

// https://www.geeksforgeeks.org/flatten-bst-to-sorted-list-increasing-order/
public class BSTToSortedLinkedList {

    static ListNode dummy = new ListNode();
    ListNode temp = dummy;

    void Inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        temp.next = new ListNode(root.val);
        temp = temp.next;
        Inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(8);

        new BSTToSortedLinkedList().Inorder(treeNode);
        while (dummy.next != null) {
            System.out.println(dummy.next.val);
            dummy = dummy.next;
        }
    }
}

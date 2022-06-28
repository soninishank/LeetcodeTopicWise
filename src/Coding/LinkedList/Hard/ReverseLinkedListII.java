package Coding.LinkedList.Hard;

import Coding.LinkedList.ListNode;

// https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Base case
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy; // which is always changing because of referencing
        ListNode leftConnector = null;

        for (int i = 0; i < left; i++) {
            leftConnector = temp;
            temp = temp.next;
        }

        // Usual reversal process
        ListNode current = temp;
        ListNode prev = leftConnector;
        for (int i = left; i <= right; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // connect them
        leftConnector.next = prev;
        temp.next = current;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = new ReverseLinkedListII().reverseBetween(listNode, 2, 4);

    }
}

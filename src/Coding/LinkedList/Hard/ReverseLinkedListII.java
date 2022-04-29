package Coding.LinkedList.Hard;

import Coding.LinkedList.ListNode;

// https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        return null;
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

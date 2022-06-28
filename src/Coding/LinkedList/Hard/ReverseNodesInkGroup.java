package Coding.LinkedList.Hard;

import Coding.LinkedList.ListNode;

// when the remaining elements are less than k - you don't need to reverse it
// https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode next = null;
        ListNode prev = null;
        int c = 0;
        ListNode curr = head;
        while (curr != null && c < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c++;
        }
        if (next != null && totalLength(next) >= k) {
            head.next = reverseKGroup(next, k);
        } else {
            head.next = next;
        }
        return prev;
    }

    private int totalLength(ListNode next) {
        ListNode temp = next;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = new ReverseNodesInkGroup().reverseKGroup(listNode, 3);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}

package Coding.LinkedList.SlowFastPointers;

import Coding.LinkedList.ListNode;

// https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow at 1x speed
            fast = fast.next.next; // move fast at 2x speed
        }
        return slow;
    }
}

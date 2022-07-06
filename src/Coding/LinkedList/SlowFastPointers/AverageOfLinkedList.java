package Coding.LinkedList.SlowFastPointers;

import Coding.LinkedList.ListNode;

// https://leetcode.com/discuss/interview-question/1398079/Microsoft-Phone-Screen-Question
public class AverageOfLinkedList {
    public ListNode averageNode(ListNode head) {
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next; // move slow at 1x speed
            fast = fast.next.next; // move fast at 2x speed
        }
        if (fast == null) {
            int i = (prev.val + slow.val) / 2;
            System.out.println(i);
        }
        return slow;
    }
}

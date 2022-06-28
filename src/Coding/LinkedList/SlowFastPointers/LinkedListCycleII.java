package Coding.LinkedList.SlowFastPointers;

import Coding.LinkedList.ListNode;

// https://leetcode.com/problems/linked-list-cycle-ii/
// detect loop in linked list
// Floyd’s Cycle detection algorithm or Hare and Tortoise algorithm - why it works ??
// Find out the stating of the cycle
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // point of intersection and mark slow as head
            // both of them move by a single pointer
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

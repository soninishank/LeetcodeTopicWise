package LinkedList.SlowFastPointers;

import LinkedList.ListNode;

// https://leetcode.com/problems/linked-list-cycle-ii/
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

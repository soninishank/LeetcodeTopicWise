package Coding.LinkedList;

// https://leetcode.com/problems/reorder-list/
// 143. Reorder List
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode secondHalf = reverseLinkedList(mid);
        mergeData(head, secondHalf);
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;

            prev = current; // move prev to next position

            current = next; // move current by one step
        }
        return prev;
    }

    private void mergeData(ListNode originalHead, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (originalHead != null && head2 != null) {
            current.next = originalHead;
            originalHead = originalHead.next;
            current = current.next;

            current.next = head2;
            head2 = head2.next;
            current = current.next;
        }
        if (originalHead != null) {
            current.next = originalHead;
        }
        if (head2 != null) {
            current.next = head2;
        }
        current.next = null;
    }
}

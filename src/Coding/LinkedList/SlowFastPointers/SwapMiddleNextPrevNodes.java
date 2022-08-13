package Coding.LinkedList.SlowFastPointers;

import Coding.LinkedList.ListNode;

public class SwapMiddleNextPrevNodes {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = head;
        ListNode slowNext = head;

        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next; // move slow at 1x speed
            fast = fast.next.next; // move fast at 2x speed
        }
        slowNext = slow.next;
        // swap
        return head;
    }

    // 1 2 3 4 5
    // 2 -> slowPrev
    // 3 -> slow
    // 4 -> slowNext
    // 2 & 4 swap
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode listNode1 = new SwapMiddleNextPrevNodes().middleNode(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}

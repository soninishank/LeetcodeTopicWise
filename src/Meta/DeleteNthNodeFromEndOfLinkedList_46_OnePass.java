package Meta;

import Coding.LinkedList.ListNode;

// https://youtu.be/ZQizovB_UdI?t=640
public class DeleteNthNodeFromEndOfLinkedList_46_OnePass {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Edge case 1: If the list is empty
        if (head == null || n <= 0) {
            return head;
        }
        ListNode temp = head;
        for (int i = 1; i <= n; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            return head.next; // Removing the first node
        }

        // Move both `temp` and `prev` pointers until `temp` reaches the last node
        ListNode prev = head; // start from head
        while (temp != null && temp.next != null) {
            prev = prev.next;
            temp = temp.next;
        }

        // Remove the nth node from the end
        prev.next = prev.next.next;

        return head;
    }
}

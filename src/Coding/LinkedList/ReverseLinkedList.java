package Coding.LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // store current next position
            curr.next = prev; // point current next to prev pointer

            prev = curr; // take prev to current position
            curr = next; // move current to next
        }
        return prev;
    }

}

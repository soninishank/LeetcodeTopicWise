package LinkedList;

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

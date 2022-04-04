package LinkedList;

public class PlusOne {
    // Insertion at end of linked list
    public ListNode plusOneInsertion(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reverse = reverseList(head);
        ListNode temp = new ListNode();
        temp.next = reverse;
        while (temp.next != null) {
            if (temp.next.val < 9) {
                temp.next.val = temp.next.val + 1;
                return reverseList(reverse);
            } else {
                temp.next.val = 0;
            }
            temp = temp.next;
        }
        ListNode front = new ListNode(1);
        temp.next = front;
        return reverseList(reverse);
    }

    public ListNode plusOne(ListNode head) {
        ListNode reverse = reverseList(head);
        ListNode temp = reverse;
        while (temp != null) {
            if (temp.val < 9) {
                temp.val = temp.val + 1;
                return reverseList(reverse);
            }
            temp.val = 0;
            temp = temp.next;
        }
        // 9 9 9 -> 0 0 0  it doesn't matter because already others are zero the reversal is same
        // 1. you don't need to reverse
        // 2. you can just simply attach
        ListNode dummy = new ListNode(1);
        dummy.next = reverse;
        return dummy;
    }

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

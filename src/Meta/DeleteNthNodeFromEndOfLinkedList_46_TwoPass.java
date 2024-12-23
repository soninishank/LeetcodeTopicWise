package Meta;

import Coding.LinkedList.ListNode;

// k == length
// k > length
// k = 1
// k <= 0
// empty list
public class DeleteNthNodeFromEndOfLinkedList_46_TwoPass {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Edge case 1: If the list is empty
        if (head == null || n <= 0) {
            return head;
        }

        int length = lengthLinkedList(head);
        // Edge case 2: If n is greater than the length of the list
        if (n > length) {
            return head;
        }
        //Edge case 3: If the nth node from the end is the first node
        if (length == n) {
            return head.next; // Remove the head node
        }

        // Step 3: Traverse to the (length - n)th node
        ListNode temp = head;
        ListNode prev = null;
        int diff = length - n;

        while (diff > 0) {
            prev = temp;
            temp = temp.next;
            diff--;
        }

        // Step 4: Remove the nth node
        if (prev != null) {
            prev.next = temp.next;
        }
        return head;
    }


    // Calculate the length of the linked list
    public int lengthLinkedList(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}

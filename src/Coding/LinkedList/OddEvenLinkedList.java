package Coding.LinkedList;

// https://leetcode.com/problems/odd-even-linked-list/
// 328. Odd Even Linked List
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddDummy = new ListNode(-1);
        ListNode odd = oddDummy;

        ListNode evenDummy = new ListNode(-1);
        ListNode even = evenDummy;

        int count = 1;
        while (head != null) {
            if (count % 2 != 0) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            count++;
        }
        even.next = null; // Terminate the even list
        odd.next = evenDummy.next; // Connect odd list with even list

        return oddDummy.next;
    }


    public ListNode oddEvenListWithoutCount(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No need to reorder if the list is empty or has only one node
        }

        // Initialize odd and even pointers
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Save the start of the even list to reconnect later

        // Iterate and rearrange
        while (even != null && even.next != null) {
            odd.next = even.next; // Connect the next odd node
            odd = odd.next;       // Move the odd pointer forward
            even.next = odd.next; // Connect the next even node
            even = even.next;     // Move the even pointer forward
        }

        // Attach the even list to the end of the odd list
        odd.next = evenHead;

        return head; // Return the reordered list
    }
}

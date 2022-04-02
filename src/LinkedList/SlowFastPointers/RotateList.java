package LinkedList.SlowFastPointers;

import LinkedList.ListNode;

// https://leetcode.com/problems/rotate-list/
// https://leetcode.com/problems/rotate-array/
// similar approach like rotate array
// Firstly reverse whole list then reverse upto k elements -> then reverse after k elements
public class RotateList {
    int size = 0;

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        // Step 1 :: Rotate the entire list , also calculate size
        head = reverseListWithSize(head); // assign it as head again, now original head has been reset

        // Step 2 : check k - out of bound handling
        k = k % size;
        if (k == 0) {
            k = size; // rotate whole list again
        }
        // Step 3 : Reverse the first k Nodes
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next; // store current next position
            curr.next = prev; // point current next to prev pointer

            prev = curr; // take prev to current position
            curr = next; // move current to next
        }
        ListNode resultUptoK = prev; // in head the changes are present
        // Step 4 : Reverse rest of the nodes
        prev = null;
        while (curr != null) { //now my current is in the middle means after k points
            ListNode next = curr.next; // store current next position
            curr.next = prev; // point current next to prev pointer

            prev = curr; // take prev to current position
            curr = next; // move current to next
        }
        head.next = prev;
        return resultUptoK;
    }

    public ListNode reverseListWithSize(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // store current next position
            curr.next = prev; // point current next to prev pointer

            prev = curr; // take prev to current position
            curr = next; // move current to next
            size++;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode result = new RotateList().rotateRight(listNode, 2);

    }
}

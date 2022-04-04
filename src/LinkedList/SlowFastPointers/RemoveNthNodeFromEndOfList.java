package LinkedList.SlowFastPointers;

import LinkedList.ListNode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfList {
    // Draw on pen and paper for better understanding
    // 1,2,3,4,5 , k = 2 --> remove the value 4
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        // Firstly get the complete size
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        ListNode dummy = new ListNode();
        dummy.next = head; // point dummy next to head
        temp = dummy;// temp is point to dummy , means it is pointing before head that's why we will check temp.next != null instead of temp != null

        int diff = size - n - 1;// diff is 5 - 2 -1 = (2) so you just need to point 2nd Node next to 2nd Node next.next
        while (temp.next != null && diff >= 0) {
            temp = temp.next;
            diff--;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}

// head -> 1,2,3,4,5  size = 5 k = 2   diff= 2
// dummy = 0,1,2,3,4,5  -> return dummy.next
// temp = 0,1,2,3,4,5
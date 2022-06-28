package Coding.LinkedList.Hard;

import Coding.LinkedList.ListNode;

// in normal reversal we are taking 3 pointers - in this we will take 4 pointers
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            // store three pointers
            ListNode firstNode = prev.next;
            ListNode secondNode = firstNode.next;
            ListNode thirdNode = secondNode.next;

            // reversal
            prev.next = secondNode;// take prev to the position where you want to do reversal in opposite direction
            secondNode.next = firstNode;// change the links  1 -> 2 becomes 2 -> 1

            // jump to the third position
            firstNode.next = thirdNode; // linking again - so  1-> 3

            prev = firstNode;
        }
        return dummy.next;
    }

}

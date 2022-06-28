package Coding.LinkedList.Hard;

import Coding.LinkedList.ListNode;

// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
public class SwapValuesNotNodes {
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        ListNode firstNode = null;
        ListNode lastNode = null;
        temp = head;
        int i = 0;
        while (temp != null && i < k - 1) {
            temp = temp.next;
            i++;
        }
        firstNode = temp;
        temp = head;
        int lastSize = size - k; // 5-2 + 1 = 4
        i = 0;
        while (temp != null && i < lastSize) {
            temp = temp.next;
            i++;
        }
        lastNode = temp;

        // swap
        int tempValue = firstNode.val;
        firstNode.val = lastNode.val;
        lastNode.val = tempValue;

        return head;
    }
}

package Coding.PriorityQueue;

import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/
// Blind-75
// Time complexity - O(NlogK) -:> O(klogK) + O(Nlogk)
// Space complexity - O(k) -> the priority queue can store k nodes at any time
public class MergeKSortedList {
    public ListNode mergeKSortedLists(ListNode[] lists) {
        // Min-heap to store the current nodes from each list, sorted by value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        // Add the head of each list to the priority queue (if it's not null)
        for (ListNode headNode : lists) {
            if (headNode != null) {
                minHeap.offer(headNode);
            }
        }
        // Dummy node to simplify result list construction
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        // Process the priority queue until all nodes are merged
        while (!minHeap.isEmpty()) {
            // Extract the node with the smallest value
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode; // Append it to the merged list
            current = current.next;
            // If there are more nodes in the list, add the next node to the queue
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }
        // Return the merged sorted list
        return dummyHead.next;
    }


    public ListNode mergeKListsUsingRecursion(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = merge(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            head = merge(head, lists[i]);
        }
        return head;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode newNode = new ListNode(list1.val);
                temp.next = newNode;
                temp = temp.next;
                list1 = list1.next;
            } else {
                ListNode newNode = new ListNode(list2.val);
                temp.next = newNode;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return dummy.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

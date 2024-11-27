package Coding.LinkedList;

import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/
// 23. Merge k Sorted Lists
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
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

    ListNode merge(ListNode list1, ListNode list2) {
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

    public ListNode mergeKListsUsingPQ(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((list1, list2) -> list1.val - list2.val);

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();

            temp.next = poll;
            temp = temp.next;

            if (poll.next != null) {
                pq.add(poll.next);
            }
        }
        return dummy.next;
    }
}

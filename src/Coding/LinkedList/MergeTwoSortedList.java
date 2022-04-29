package Coding.LinkedList;

public class MergeTwoSortedList {
    // similar like merge sort
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // check if both the nodes are null
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) { // if any one of the node is null
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            ListNode dummy = new ListNode();
            ListNode temp = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    temp.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    temp.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                temp = temp.next;
            }
            while (list1 != null) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
                temp = temp.next;
            }
            while (list2 != null) {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
                temp = temp.next;
            }
            return dummy.next;
        }
    }
}

package Coding.LinkedList;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// 83. Remove Duplicates from Sorted List
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        // Initialize a pointer to the current node
        ListNode current = head;
        // Iterate through the list until we reach the end
        while (current != null && current.next != null) {
            // If the current value is the same as the next value, skip the next node
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // Move to the next node if no duplicate
                current = current.next;
            }
        }
        // Return the modified list
        return head;
    }
}

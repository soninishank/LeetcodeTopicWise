package Coding.LinkedList;

// 82. Remove Duplicates from Sorted List II
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // Create a dummy node to handle edge cases where the first node has duplicates
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Use two pointers: prev to track the node before the current sequence of duplicates, and curr to iterate
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // Check if current node has duplicates
            if (curr.next != null && curr.val == curr.next.val) {
                // Skip all nodes with the same value
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // Skip the last duplicate node as well
                prev.next = curr.next;
            } else {
                // Move prev pointer to the current node if no duplicates
                prev = prev.next;
            }
            // Move curr to the next node
            curr = curr.next;
        }

        // Return the modified list, starting from dummy's next node
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);

        ListNode listNode1 = new RemoveDuplicatesFromSortedListII().deleteDuplicates(listNode);

    }
}

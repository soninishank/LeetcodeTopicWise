package LinkedList;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;

        while (temp.next != null) {
            while (temp.next.next != null && temp.next.val == temp.next.next.val) {
                temp = temp.next.next.next;
            }
            temp = temp.next;
        }
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

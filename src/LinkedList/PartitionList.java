package LinkedList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode smallTemp = smallDummy;
        ListNode largeDummy = new ListNode(-1);
        ListNode largeTemp = largeDummy;
        while (head != null) {
            if (head.val < x) {
                smallTemp.next = head;
                smallTemp = smallTemp.next;
            } else {
                largeTemp.next = head;
                largeTemp = largeTemp.next;
            }
            head = head.next;
        }
        largeTemp.next = null; // we do this because in line 14 you are adding head, so there are still extra elements
        // present which are not needed
        smallTemp.next = largeDummy.next; // do the linking
        return smallDummy.next; // return smallDummy
    }
}

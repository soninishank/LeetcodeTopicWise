package Coding.LinkedList;

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

    public ListNode partitionByPivot(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode smallTemp = smallDummy;
        ListNode largeDummy = new ListNode(-1);
        ListNode largeTemp = largeDummy;
        ListNode original = new ListNode(-1);
        ListNode originalTemp = original;
        while (head != null) {
            if (head.val < x) {
                smallTemp.next = head;
                smallTemp = smallTemp.next;
            } else if (head.val > x) {
                largeTemp.next = head;
                largeTemp = largeTemp.next;
            } else {
                originalTemp.next = head;
                originalTemp = originalTemp.next;
            }
            head = head.next;
        }
        largeTemp.next = null;
        originalTemp.next = largeDummy.next;
        smallTemp.next = original.next;
        return smallDummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(2);
        ListNode listNode1 = new PartitionList().partitionByPivot(listNode, 3);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}

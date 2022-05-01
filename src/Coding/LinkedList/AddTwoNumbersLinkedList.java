package Coding.LinkedList;

// https://leetcode.com/problems/add-two-numbers/
// Do its other variation - mostly asked as a follow-up question
public class AddTwoNumbersLinkedList {
    // sum = 11 , sum / 10 = 1 -> quotient -> carry
    // sum = 11 , sum % 10 = 1 -> remainder -> current value
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            ListNode tempNode = new ListNode(sum % 10);
            temp.next = tempNode;
            temp = temp.next;
        }
        // after traversing all the elements you might left with carry
        if (carry > 0) {
            ListNode listNode = new ListNode(carry);
            temp.next = listNode;
            temp = temp.next;
        }
        return dummy.next;
    }
}

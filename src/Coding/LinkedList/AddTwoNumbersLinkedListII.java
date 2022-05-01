package Coding.LinkedList;

import java.util.Stack;

// https://leetcode.com/problems/add-two-numbers-ii/
// 1. Using stacks and then reverse
//
public class AddTwoNumbersLinkedListII {
    // 1. Using stacks and then reverse
    /* public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack1.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while (!stack.isEmpty() || !stack1.isEmpty()) {
            int sum = carry;
            if (!stack.isEmpty()) {
                sum += stack.pop();
            }
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            temp = temp.next;
            carry = sum / 10;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
        }
        return reverse(dummy.next); // do single reverse
    }
    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    } */

    // 2. Using stacks and reversal while creating the node itself
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack1.push(l2.val);
            l2 = l2.next;
        }
        // used for in place reversal
        ListNode prev = null;
        ListNode current;
        int carry = 0;
        while (!stack.isEmpty() || !stack1.isEmpty()) {
            int sum = carry;
            if (!stack.isEmpty()) {
                sum += stack.pop();
            }
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            current = new ListNode(sum % 10);
            current.next = prev;
            prev = current;
            carry = sum / 10;
        }
        if (carry > 0) {
            current = new ListNode(carry);
            current.next = prev;
            prev = current;
        }
        return prev;
    }
}

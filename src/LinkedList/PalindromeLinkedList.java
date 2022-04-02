package LinkedList;

// constant space - O(1) - https://leetcode.com/problems/palindrome-linked-list/
// Bruteforce - create an List<Integer> , then check list is palindrome or not
// 1.Find the end of the first half. ==> using two pointers we will find out the middle element
// 2.Reverse the second half.
// 3.Determine whether there is a palindrome or not.
// 4.Restore the list.
// 5.Return the result.
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode firstHalfEnd = endFirstHalf(head);
        ListNode reverseSecondHalfList = reverseSecondHalf(firstHalfEnd.next);

        // Now we compare both the above ListNode
        ListNode headA = head; // because the pointer of firstHalfEnd is at end of mid
        ListNode headB = reverseSecondHalfList;
        boolean result = true; // we are taking this variable bcz we can return this in last
        while (headA != null && headB != null) {
            if (headA.val != headB.val) {
                result = false;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        // Now restore the original list
        firstHalfEnd.next = reverseSecondHalf(reverseSecondHalfList);
        return result;
    }

    // using two pointers - similar like middle element
    // if odd number than middle node will be attached to the first half
    private ListNode endFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // reverse second half
    private ListNode reverseSecondHalf(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // store current next position
            curr.next = prev; // point current next to prev pointer

            prev = curr; // take prev to current position
            curr = next; // move current to next
        }
        return prev;
    }

}

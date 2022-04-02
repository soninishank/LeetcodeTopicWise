package LinkedList;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {
    // Take pen and paper , draw the diagram
    // 4 -> 1 -> 8 -> 4 -> 5(next is null,point to headB) -> 5                               -> 6 -> 1 -> 8 (intersection point)
    // 5 -> 6 -> 1 -> 8 -> 4                              -> 5 (next is null,point to headA) -> 4 -> 1 -> 8 (intersection point)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        } else if (headA == null) {
            return headB;
        } else if (headB == null) {
            return headA;
        } else {
            ListNode temp1 = headA;
            ListNode temp2 = headB;
            while (temp1 != null || temp2 != null) {
                if (temp1 == temp2) {
                    return temp1;
                }
                if (temp1 != null) {
                    temp1 = temp1.next;
                } else {
                    temp1 = headB;
                }
                if (temp2 != null) {
                    temp2 = temp2.next;
                } else {
                    temp2 = headA;
                }
            }
        }
        return null;
    }


}

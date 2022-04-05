package Tree.BinarySearchTree.Easy;

import LinkedList.ListNode;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return buildTree(list, 0, list.size() - 1);
    }

    TreeNode buildTree(List<Integer> list, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildTree(list, low, mid - 1);
        node.right = buildTree(list, mid + 1, high);
        return node;
    }
}

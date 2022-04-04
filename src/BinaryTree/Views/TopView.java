package BinaryTree.Views;

import BinaryTree.TreeNode;

import java.util.*;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22
 */
public class TopView {

    List<Integer> resultList = new ArrayList<>();

    private List<Integer> topView(TreeNode root) {
        if (null == root) {
            return resultList;
        }
        Queue<RowColDirection> queue = new LinkedList<>();
        queue.add(new RowColDirection(0, root));
        TreeMap<Integer, List<Integer>> hashMap = new TreeMap<>();
        while (!queue.isEmpty()) {
            RowColDirection poll = queue.poll();
            if (!hashMap.containsKey(poll.col)) {
                hashMap.put(poll.col, new ArrayList<>());
                hashMap.get(poll.col).add(poll.treeNode.val);
            }
            if (poll.treeNode.left != null) {
                queue.add(new RowColDirection(poll.col - 1, poll.treeNode.left));
            }
            if (poll.treeNode.right != null) {
                queue.add(new RowColDirection(poll.col + 1, poll.treeNode.right));
            }
        }
        for (int key : hashMap.keySet()) {
            List<Integer> list = hashMap.get(key);
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    resultList.add(list.get(i));
                }
            }
        }
        return resultList;
    }
}

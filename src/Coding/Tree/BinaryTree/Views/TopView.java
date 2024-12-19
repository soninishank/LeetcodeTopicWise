package Coding.Tree.BinaryTree.Views;

import Coding.Tree.TreeNode;

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
        Queue<TreeNodeInfo> queue = new LinkedList<>();
        queue.add(new TreeNodeInfo(0, root));
        TreeMap<Integer, List<Integer>> hashMap = new TreeMap<>();
        while (!queue.isEmpty()) {
            TreeNodeInfo poll = queue.poll();
            if (!hashMap.containsKey(poll.column)) {
                hashMap.put(poll.column, new ArrayList<>());
                hashMap.get(poll.column).add(poll.treeNode.val);
            }
            if (poll.treeNode.left != null) {
                queue.add(new TreeNodeInfo(poll.column - 1, poll.treeNode.left));
            }
            if (poll.treeNode.right != null) {
                queue.add(new TreeNodeInfo(poll.column + 1, poll.treeNode.right));
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

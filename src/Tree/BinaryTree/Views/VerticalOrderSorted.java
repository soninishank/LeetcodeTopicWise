package Tree.BinaryTree.Views;

import Tree.TreeNode;

import java.util.*;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22 - 987 leetcode
 */
// treemap of treemap
// Inside TreeMap<Key,Value> -> key is row and value is PriorityQueue
// Main TreeMap<Key,Value> -> key is column  and Value is above treeMap
public class VerticalOrderSorted {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> resultMap = new TreeMap<>();
        Queue<RowColDirection> queue = new LinkedList<>();
        queue.add(new RowColDirection(0, 0, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                RowColDirection poll = queue.poll();
                if (!resultMap.containsKey(poll.col)) {
                    resultMap.put(poll.col, new TreeMap<>());
                }
                if (!resultMap.get(poll.col).containsKey(poll.row)) {
                    resultMap.get(poll.col).put(poll.row, new PriorityQueue<>());
                }
                resultMap.get(poll.col).get(poll.row).add(poll.treeNode.val);
                if (poll.treeNode.left != null) {
                    queue.add(new RowColDirection(poll.row + 1, poll.col - 1, poll.treeNode.left));
                }
                if (poll.treeNode.right != null) {
                    queue.add(new RowColDirection(poll.row + 1, poll.col + 1, poll.treeNode.right));
                }
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (Integer key : resultMap.keySet()) {
            TreeMap<Integer, PriorityQueue<Integer>> treeMap = resultMap.get(key);
            List<Integer> list = new ArrayList<>();
            for (Integer integer : treeMap.keySet()) {
                PriorityQueue<Integer> priorityQueue = treeMap.get(integer);
                while (!priorityQueue.isEmpty()) {
                    list.add(priorityQueue.poll());
                }
            }
            resultList.add(list);
        }
        return resultList;
    }
}

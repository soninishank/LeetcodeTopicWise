package Coding.Tree.BinaryTree.Views;

import Coding.Tree.TreeNode;

import java.util.*;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22 - 987 leetcode
 */
// treemap of treemap
// Main TreeMap<Key,Value> -> key is column  and Value is treeMap - see below line
// Inside TreeMap<Key,Value> -> key is row and value is PriorityQueue - minPQ - to get sortedOrder
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// Use this example for learning -> [3,1,4,0,2,2] , you can't use old code beacuse it will make the result as [[0],[1],[3,2,2],[4]]
// instead of [[0],[1],[2,2,3],[4]]. 
public class VerticalOrderSorted {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        // A TreeMap to store columns and their corresponding rows and values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> columnMap = new TreeMap<>();
        Queue<TreeNodeInfo> nodeQueue = new LinkedList<>();

        // Start BFS traversal with the root node
        nodeQueue.add(new TreeNodeInfo(0, 0, root));

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeInfo currentNodeInfo = nodeQueue.poll();

                // Ensure the column exists in the columnMap
                columnMap.putIfAbsent(currentNodeInfo.column, new TreeMap<>());

                // Ensure the row exists within the column
                columnMap.get(currentNodeInfo.column).putIfAbsent(currentNodeInfo.row, new PriorityQueue<>());

                // Add the current node's value to the corresponding PriorityQueue
                columnMap.get(currentNodeInfo.column).get(currentNodeInfo.row).add(currentNodeInfo.node.val);

                // Add left and right children to the queue with updated row and column
                if (currentNodeInfo.node.left != null) {
                    nodeQueue.add(new TreeNodeInfo(currentNodeInfo.row + 1, currentNodeInfo.column - 1, currentNodeInfo.node.left));
                }
                if (currentNodeInfo.node.right != null) {
                    nodeQueue.add(new TreeNodeInfo(currentNodeInfo.row + 1, currentNodeInfo.column + 1, currentNodeInfo.node.right));
                }
            }
        }

        // Prepare the final result list
        List<List<Integer>> result = new ArrayList<>();
        for (Integer column : columnMap.keySet()) {
            TreeMap<Integer, PriorityQueue<Integer>> rowMap = columnMap.get(column);
            List<Integer> columnValues = new ArrayList<>();
            for (Integer row : rowMap.keySet()) {
                PriorityQueue<Integer> values = rowMap.get(row);
                while (!values.isEmpty()) {
                    columnValues.add(values.poll());
                }
            }
            result.add(columnValues);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        List<List<Integer>> list = new VerticalOrderSorted().verticalTraversal(treeNode);
        System.out.println(list);
    }
}

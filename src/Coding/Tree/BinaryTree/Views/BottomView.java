package Coding.Tree.BinaryTree.Views;

import Coding.Tree.TreeNode;

import java.util.*;

// Just add all the column
// then get the last value of that column
public class BottomView {
    ArrayList<Integer> resultList = new ArrayList<>();

    public List<Integer> bottomView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        // Queue for level-order traversal
        Queue<RowColDirection> queue = new LinkedList<>();
        queue.add(new RowColDirection(0, root));

        // TreeMap to store the bottom view (HD -> Node Value)
        TreeMap<Integer, Integer> columnMap = new TreeMap<>();

        // Level-order traversal
        while (!queue.isEmpty()) {
            RowColDirection current = queue.poll();
            int col = current.col;
            TreeNode node = current.treeNode;

            // Update the map with the current node's value
            columnMap.put(col, node.val);

            // Add left and right children to the queue
            if (node.left != null) {
                queue.add(new RowColDirection(col - 1, node.left));
            }
            if (node.right != null) {
                queue.add(new RowColDirection(col + 1, node.right));
            }
        }

        // Add all column values to the result list
        resultList.addAll(columnMap.values());

        return resultList;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);


        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        treeNode.right.right = new TreeNode(6);

        List<Integer> list = new BottomView().bottomView(treeNode);
        System.out.println(list);
    }

}

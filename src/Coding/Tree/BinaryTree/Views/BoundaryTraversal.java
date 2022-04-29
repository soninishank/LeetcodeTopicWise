package Coding.Tree.BinaryTree.Views;

import Coding.Tree.TreeNode;

import java.util.*;

/**
 * @author Nishank Soni
 * @project Leet Code Topic Wise on 4/1/22
 */
// print root
// print left view - without leaf node
// print bottom view - include only leaf node
// print right view - without leaf node
public class BoundaryTraversal {

    ArrayList<Integer> resultList = new ArrayList<>();

    ArrayList<Integer> printBoundary(TreeNode root) {
        if (root == null) {
            return resultList;
        }
        resultList.add(root.val);
        printLeftViewExcludeLeafNode(root.left);
        printBottomViewIncludeOnlyLeafNode(root);
        printRightViewExcludeLeafNode(root.right);
        return resultList;
    }

    private void printLeftViewExcludeLeafNode(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // exclude leaf node
                if (poll.left == null && poll.right == null) {
                    continue;
                }
                if (i == 0) {
                    resultList.add(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
    }

    private void printBottomViewIncludeOnlyLeafNode(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<RowColDirection> queue = new LinkedList<>();
        queue.add(new RowColDirection(0, root));
        TreeMap<Integer, List<Integer>> hashMap = new TreeMap<>();
        while (!queue.isEmpty()) {
            RowColDirection poll = queue.poll();
            if (poll.treeNode.left == null && poll.treeNode.right == null) {
                if (!hashMap.containsKey(poll.col)) {
                    hashMap.put(poll.col, new ArrayList<>());
                    hashMap.get(poll.col).add(poll.treeNode.val);
                } else {
                    hashMap.get(poll.col).add(poll.treeNode.val);
                }
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
                if (i == list.size() - 1) {
                    resultList.add(list.get(i));
                }
            }
        }
    }

    private void printRightViewExcludeLeafNode(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    continue;
                }
                if (i == size - 1) {
                    resultList.add(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
    }

// 4 10 N 5 5 N 6 7 N 8 8 N 8 11 N 3 4 N 1 3 N 8 6 N 11 11 N 5 8


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(9);

        tree.left.left.left = new TreeNode(6);
        tree.left.left.right = new TreeNode(5);
        tree.left.right.right = new TreeNode(3);


        tree.left.right.right.left = new TreeNode(7);
        tree.left.right.right.right = new TreeNode(8);



        ArrayList<Integer> integers = new BoundaryTraversal().printBoundary(tree);
        System.out.println(integers);
    }
}

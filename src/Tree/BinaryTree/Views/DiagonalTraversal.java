package Tree.BinaryTree.Views;

import Tree.TreeNode;

import java.util.*;

// Right side -> 0 - same value on each step
// left side -> -1 on each step
// https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
public class DiagonalTraversal {

    List<List<Integer>> resultList = new ArrayList<>();

    private void diagonalPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        Queue<RowColDirection> queue = new LinkedList<>();
        queue.add(new RowColDirection(0, root));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                RowColDirection poll = queue.poll();
                if (!hashMap.containsKey(poll.col)) {
                    hashMap.put(poll.col, new ArrayList<>());
                }
                hashMap.get(poll.col).add(poll.treeNode.val);
                if (poll.treeNode.left != null) {
                    queue.add(new RowColDirection(poll.col - 1, poll.treeNode.left));
                }
                if (poll.treeNode.right != null) {
                    queue.add(new RowColDirection(poll.col, poll.treeNode.right));
                }
            }
        }
        System.out.println(hashMap);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        new DiagonalTraversal().diagonalPrint(root);
    }
}

package Coding.Tree.BinaryTree.Parent;

import Coding.Tree.TreeNode;

import java.util.*;

public class MinTimeToBurnACompleteTree {

    public int minTime(TreeNode root, TreeNode target) {
        HashMap<TreeNode, TreeNode> parentNodeReference = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        buildParentRef(root, parentNodeReference);
        int value = dfs(root, target, parentNodeReference);
        return value;
    }


    private void buildParentRef(TreeNode root, HashMap<TreeNode, TreeNode> parentRef) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parentRef.put(root, null);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
                parentRef.put(poll.left, poll);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                parentRef.put(poll.right, poll);
            }
        }
    }

    // when the adjacent node start burning they all start burning the nearby nodes at once

    private int dfs(TreeNode root, TreeNode target, HashMap<TreeNode, TreeNode> parentRefHashMap) {
        if (root == null) {
            return 0;
        }
        HashSet<TreeNode> visitedHashset = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visitedHashset.add(target);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            currentLevel++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // left
                if (poll.left != null && !visitedHashset.contains(poll.left)) {
                    queue.add(poll.left);
                    visitedHashset.add(poll.left);
                }
                // right
                if (poll.right != null && !visitedHashset.contains(poll.right)) {
                    queue.add(poll.right);
                    visitedHashset.add(poll.right);
                }
                // parent hash map - upward
                if (parentRefHashMap.get(poll) != null && !visitedHashset.contains(parentRefHashMap.get(poll))) {
                    queue.add(parentRefHashMap.get(poll));
                    visitedHashset.add(parentRefHashMap.get(poll));
                }
            }
        }
        return currentLevel;
    }
}

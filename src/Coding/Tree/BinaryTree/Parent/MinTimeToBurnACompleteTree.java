package Coding.Tree.BinaryTree.Parent;

import Coding.Tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// Burn the binary tree starting from the target node
// https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/
// Three directions
// 1.left
// 2.right
// 3.Parent Node
public class MinTimeToBurnACompleteTree {

    public int minTime(TreeNode root, TreeNode target) {
        HashMap<TreeNode, TreeNode> parentNodeReferenceHashMap = new HashMap<>();
        buildParentRef(root, parentNodeReferenceHashMap);
        int value = dfs(root, target, parentNodeReferenceHashMap);
        return value;
    }


    // Build a hashmap of node with parent reference
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
            currentLevel++;
        }
        return currentLevel;
    }
}

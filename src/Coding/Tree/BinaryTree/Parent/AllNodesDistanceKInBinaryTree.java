package Coding.Tree.BinaryTree.Parent;

import Coding.Tree.TreeNode;

import java.util.*;

// Hashmap -> for storing the reference of parent pointers
// visited hashset -> to mark the visited node
// traversal - left , right , upwards - Coding.BFS
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// 863. All Nodes Distance K in Binary Tree
public class AllNodesDistanceKInBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentRefHashMap = new HashMap<>();
        buildParentRef(root, parentRefHashMap);

        List<Integer> list = new ArrayList<>();
        dfs(root, target, k, parentRefHashMap, list);
        return list;
    }


    // create hashmap of <Node, ParentNode>
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

    private void dfs(TreeNode root, TreeNode target, int k, HashMap<TreeNode, TreeNode> parentRefHashMap, List<Integer> resultList) {
        if (root == null) {
            return;
        }
        HashSet<TreeNode> visitedHashset = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visitedHashset.add(target);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentLevel == k) {
                break;
            }
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
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            resultList.add(poll.val);
        }
        return;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.left.right = new TreeNode(4);

        treeNode.right.left = new TreeNode(0);
        treeNode.right.left.right = new TreeNode(8);

        List<Integer> list = new AllNodesDistanceKInBinaryTree().distanceK(treeNode, treeNode.left, 2);
        System.out.println(list);
    }
}

package Tree.BinaryTree.Paths;

import Tree.TreeNode;

import java.util.HashMap;

// similar like prefix sum
// same approach exactly
// any node to any other node - sum is equal to target - return the count
// https://leetcode.com/problems/path-sum-iii/
// HashMap - key value - key is current sum and value is Index
public class PathSumIII {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        getPrefixSum(root, targetSum, 0);
        return count;
    }

    private void getPrefixSum(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        if (currentSum == targetSum) {
            count++;
        }
        int val = currentSum - targetSum;
        if (hashMap.containsKey(val)) {
            count += hashMap.getOrDefault(val, 0);
        }
        hashMap.put(currentSum, hashMap.getOrDefault(currentSum, 0) + 1); // choose
        getPrefixSum(root.left, targetSum, currentSum);
        getPrefixSum(root.right, targetSum, currentSum);
        hashMap.put(currentSum, hashMap.getOrDefault(currentSum, 0) - 1);// un-choose backtracking
    }
}

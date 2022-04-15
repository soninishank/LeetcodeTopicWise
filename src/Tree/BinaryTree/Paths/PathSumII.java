package Tree.BinaryTree.Paths;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/
// Root to leaf all paths which matches the value of targetSum - return a list
public class PathSumII {

    List<List<Integer>> resultPathSum = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return resultPathSum;
        }
        getListPathSum(root, targetSum, new ArrayList<>());
        return resultPathSum;
    }

    private void getListPathSum(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        path.add(root.val); // choose
        // Hypothesis
        if (targetSum == 0 && root.left == null && root.right == null) {
            resultPathSum.add(new ArrayList<>(path));
        }
        getListPathSum(root.left, targetSum, path);
        getListPathSum(root.right, targetSum, path);
        path.remove(path.size() - 1); // un choose - similar to backtracking
    }

}

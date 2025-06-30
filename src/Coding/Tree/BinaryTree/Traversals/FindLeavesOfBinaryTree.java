package Coding.Tree.BinaryTree.Traversals;

import Coding.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/find-leaves-of-binary-tree/
public class FindLeavesOfBinaryTree {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return result;
        }
        HashMap<Integer, List<Integer>> heightMap = new HashMap<>();
        getHeight(root, heightMap);
        for (int key : heightMap.keySet()) {
            result.add(heightMap.get(key));
        }
        return result;
    }

    // It is exactly the same as MaximumDepthBinaryTree example
    private int getHeight(TreeNode root, HashMap<Integer, List<Integer>> heightMap) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left, heightMap);
        int right = getHeight(root.right, heightMap);
        int maxHeight = 1 + Math.max(left, right);
        heightMap.computeIfAbsent(maxHeight, k -> new ArrayList<>()).add(root.val);
        return maxHeight;
    }
}

package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeavesOfImbalanceBinaryTrees {
    private final List<List<Integer>> result = new ArrayList<>();
    private final HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return result;
        }
        getHeightData(root);
        for (int key : hashMap.keySet()) {
            result.add(new ArrayList<>(hashMap.get(key)));
        }
        return result;
    }

    void getHeightData(TreeNode root) {
        if (root == null) {
            return;
        }
        int height = calcHeight(root);
        hashMap.putIfAbsent(height, new ArrayList<>());
        hashMap.get(height).add(root.val);
        getHeightData(root.left);
        getHeightData(root.right);
    }

    private int calcHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(calcHeight(root.left), calcHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        List<List<Integer>> leaves = new LeavesOfImbalanceBinaryTrees().findLeaves(treeNode);
        System.out.println(leaves);
    }
}

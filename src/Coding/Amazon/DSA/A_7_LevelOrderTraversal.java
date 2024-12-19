package Coding.Amazon.DSA;

import Coding.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A_7_LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pollVal = queue.poll();
                list.add(pollVal.val);
                if (pollVal.left != null) {
                    queue.add(pollVal.left);
                }
                if (pollVal.right != null) {
                    queue.add(pollVal.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}

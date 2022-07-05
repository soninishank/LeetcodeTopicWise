package Coding.Tree.BinaryTree;

import Coding.Tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-duplicate-subtrees/
public class FindDuplicateTrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) {
            return "#";
        }
        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            res.add(cur);
        }
        return serial;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.right = new TreeNode(4);

        treeNode.right.left.left = new TreeNode(4);

        List<TreeNode> duplicateSubtrees = new FindDuplicateTrees().findDuplicateSubtrees(treeNode);
        System.out.println(duplicateSubtrees);
    }
}

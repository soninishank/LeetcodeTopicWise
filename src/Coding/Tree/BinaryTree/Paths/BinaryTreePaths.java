package Coding.Tree.BinaryTree.Paths;

import Coding.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

// easy - draw on pen and paper
//https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths {

    List<String> resultList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return resultList;
        }
        getAllPathsFromRootToLeaf(root, "");
        return resultList;
    }

    private void getAllPathsFromRootToLeaf(TreeNode root, String str) {
        if (root == null) {
            return;
        }
        // Because we want to go till the leaf node
        if (root.left == null && root.right == null) {
            str += root.val;
            resultList.add(str);
            return;
        }
        str += root.val + "->";
        getAllPathsFromRootToLeaf(root.left, str);
        getAllPathsFromRootToLeaf(root.right, str);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);
        List<String> strings = new BinaryTreePaths().binaryTreePaths(treeNode);
        System.out.println(strings);
    }
}

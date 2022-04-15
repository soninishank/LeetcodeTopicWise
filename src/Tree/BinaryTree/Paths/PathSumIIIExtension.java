package Tree.BinaryTree.Paths;

// PathsThatSumToKBinaryTree

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/discuss/interview-question/913940/oci-phone-find-all-paths-that-sum-to-k-in-a-binary-tree
// any node to other node - return all paths
public class PathSumIIIExtension {

    List<List<Integer>> resultKPathSum = new ArrayList<>();
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>(); // key is cumulative sum and value is List<Integers>

    private List<List<Integer>> KPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return resultKPathSum;
        }
        getAllPathsPrefixSum(root, targetSum, 0, new ArrayList<>());
        return resultKPathSum;
    }

    private void getAllPathsPrefixSum(TreeNode root, int targetSum, int currentSum, List<Integer> nodeList) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        nodeList.add(root.val); // choose

        int valToFind = currentSum - targetSum;
        if (hashMap.containsKey(valToFind)) {
            List<Integer> prevIndexPath = hashMap.get(valToFind);
            List<Integer> tempList = new ArrayList<>();
            // sublist index
            for (int i = prevIndexPath.size(); i < nodeList.size(); i++) {
                tempList.add(nodeList.get(i));
            }
            resultKPathSum.add(tempList);
        }
        hashMap.put(currentSum, new ArrayList<>(nodeList));
        getAllPathsPrefixSum(root.left, targetSum, currentSum, nodeList);
        getAllPathsPrefixSum(root.right, targetSum, currentSum, nodeList);
        nodeList.remove(nodeList.size() - 1);// un-choose backtracking
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(-3);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(11);

        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.right = new TreeNode(-2);
        treeNode.left.right.right = new TreeNode(1);

        List<List<Integer>> lists = new PathSumIIIExtension().KPathSum(treeNode, 8);
        System.out.println(lists);
    }
}

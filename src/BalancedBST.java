import Coding.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalancedBST {


    private List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return buildTree(list, root, 0, list.size()-1);
    }

    private TreeNode buildTree(List<Integer> list, TreeNode root, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildTree(list, root, start, mid - 1);
        node.right = buildTree(list, root, mid + 1, end);
        return node;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        treeNode.right.right.right = new TreeNode(4);
        TreeNode treeNode1 = new BalancedBST().balanceBST(treeNode);


        Class<?> aClass = Class.forName(String.valueOf(BalancedBST.class));
        BalancedBST balancedBST = (BalancedBST) aClass.newInstance();

    }
}

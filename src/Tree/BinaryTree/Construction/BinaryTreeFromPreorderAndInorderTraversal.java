package Tree.BinaryTree.Construction;

import Tree.TreeNode;

import java.util.HashMap;


// PreOrder -> root -> left -> right
// InOrder -> left -> root -> right
// The first value of PreOrder is root , we will pick that first

public class BinaryTreeFromPreorderAndInorderTraversal {
    int preOrderIndex = 0; // declare the variable globally  otherwise local variable will not work

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildPreOrder(preorder, hashMap, 0, preorder.length - 1);
    }

    private TreeNode buildPreOrder(int[] preorder, HashMap<Integer, Integer> hashMap, int low, int high) {
        if (low > high) {
            return null;
        }
        if (preOrderIndex > preorder.length - 1) {
            return null;
        }
        int firstValue = preorder[preOrderIndex++];
        Integer midIndex = hashMap.get(firstValue);
        TreeNode treeNode = new TreeNode(firstValue); // PreOrder root - first element
        treeNode.left = buildPreOrder(preorder, hashMap, low, midIndex - 1);// PreOrder left
        treeNode.right = buildPreOrder(preorder, hashMap, midIndex + 1, high);// PreOrder right
        return treeNode;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = new BinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);

    }
}

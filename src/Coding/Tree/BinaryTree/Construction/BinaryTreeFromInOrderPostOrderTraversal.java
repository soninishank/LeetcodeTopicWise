package Coding.Tree.BinaryTree.Construction;

import Coding.Tree.TreeNode;

import java.util.HashMap;

// PostOrder -> left -> right -> root
// InOrder -> left -> root -> right
// The last value of PostOrder is root, we will pick that first

// when we are building - we can follow the same approach - just opposite of postorder - root -> right -> left
public class BinaryTreeFromInOrderPostOrderTraversal {
    int postOrderIndex; // declare the variable globally  otherwise local variable will not work

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        postOrderIndex = postorder.length - 1; // start from back because root is at the back
        return buildPostOrder(postorder, hashMap, 0, postorder.length - 1);
    }

    private TreeNode buildPostOrder(int[] postOrder, HashMap<Integer, Integer> hashMap, int low, int high) {
        if (low > high) {
            return null;
        }
        if (postOrderIndex < 0) {
            return null;
        }
        int firstValue = postOrder[postOrderIndex--];
        Integer midIndex = hashMap.get(firstValue);
        TreeNode treeNode = new TreeNode(firstValue); // PostOrder root - last element
        treeNode.right = buildPostOrder(postOrder, hashMap, midIndex + 1, high); // PostOrder right

        treeNode.left = buildPostOrder(postOrder, hashMap, low, midIndex - 1); // PostOrder left
        return treeNode;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = new BinaryTreeFromInOrderPostOrderTraversal().buildTree(postorder, inorder);
    }
}

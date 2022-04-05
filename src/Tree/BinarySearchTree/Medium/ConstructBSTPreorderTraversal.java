package Tree.BinarySearchTree.Medium;

import Tree.TreeNode;

// Similar concept like SortedArrayToBST
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// There are two ways :
// 1.https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// 2. explained below
public class ConstructBSTPreorderTraversal {
    int preIndex = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode buildTree(int[] preorder, int lowerBound, int upperBound) {
        if (preIndex >= preorder.length) { // check index out of bound
            return null;
        }
        if (preorder[preIndex] < lowerBound || preorder[preIndex] > upperBound) { // check boundaries
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex]); // first index is the root element
        preIndex++; // increase index
        node.left = buildTree(preorder, lowerBound, node.val);
        node.right = buildTree(preorder, node.val, upperBound);
        return node;
    }
}
// 8,5,1,7,10,12
// 8 is root
// the numbers which are less than 8 are on left side - 5,1,7
// the numbers which are greater than 8 are on right side - 10,12

//package Meta;
//
//import Coding.Tree.TreeNode;
//
//import java.util.Stack;
//
//public class BinaryTreeIteratorForInorderTraversal {
//    private Stack<TreeNode> stack;
//
//    public BinaryTreeIteratorForInorderTraversal(TreeNode root) {
//        stack = new Stack<>();
//        pushLeftNodes(root); // Initialize stack with the leftmost path
//    }
//
//    // Check if there are more nodes to traverse
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//
//    // Return the next node in in-order traversal
//    public int next() {
//        if (!hasNext()) {
//            throw new RuntimeException("No more nodes to traverse");
//        }
//        TreeNode current = stack.pop();
//        int result = current.val;
//
//        // If the current node has a right child, process its leftmost subtree
//        if (current.right != null) {
//            pushLeftNodes(current.right);
//        }
//
//        return result;
//    }
//}

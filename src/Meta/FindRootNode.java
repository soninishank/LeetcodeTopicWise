package Meta;

import Coding.Tree.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRootNode {
    public static TreeNode findRoot(List<TreeNode> nodes) {
        Set<TreeNode> children = new HashSet<>();
        // Add all left and right children to the set
        for (TreeNode node : nodes) {
            if (node.left != null) {
                children.add(node.left);
            }
            if (node.right != null) {
                children.add(node.right);
            }
        }
        // The root node is the one that is not in the children set
        for (TreeNode node : nodes) {
            if (!children.contains(node)) {
                return node;
            }
        }
        // Should never reach here if the input is valid
        return null;
    }

    public static void main(String[] args) {
        // Example Tree:
        //        N1
        //       /  \
        //     N2    N3
        //           /
        //         N4

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;

        List<TreeNode> nodes = Arrays.asList(n3, n2, n4, n1); // Random order
        TreeNode root = findRoot(nodes);

        System.out.println("Root Node: " + root.val); // Output: 1
    }
}

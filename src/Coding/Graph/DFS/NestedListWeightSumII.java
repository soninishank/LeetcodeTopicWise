package Coding.Graph.DFS;

import java.util.List;

public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = findMaximumDepth(nestedList);
        return calculateDepthSumInverse(nestedList, maxDepth, 1);
    }

    // Recursively finds the maximum depth in the nested list, ignoring empty lists
    private int findMaximumDepth(List<NestedInteger> nestedList) {
        int depth = 1;
        for (NestedInteger nestedInteger : nestedList) {
            if (!nestedInteger.isInteger() && !nestedInteger.getList().isEmpty()) {
                depth = Math.max(depth, 1 + findMaximumDepth(nestedInteger.getList()));
            }
        }
        return depth;
    }

    // Recursively calculates the weighted sum based on the depth of each integer
    private int calculateDepthSumInverse(List<NestedInteger> nestedList, int maxDepth, int currentDepth) {
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                // Weight is maxDepth - currentDepth + 1
                int weight = maxDepth - currentDepth + 1;
                sum += nestedInteger.getInteger() * weight;
            } else {
                sum += calculateDepthSumInverse(nestedInteger.getList(), maxDepth, currentDepth + 1);
            }
        }
        return sum;
    }
}
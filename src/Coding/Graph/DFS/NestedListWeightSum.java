package Coding.Graph.DFS;

import java.util.Collections;
import java.util.List;

public class NestedListWeightSum implements NestedInteger {

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return 0;
    }

    @Override
    public List<NestedInteger> getList() {
        return Collections.emptyList();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList.size() == 0) {
            return 0;
        }
        return calculateDepthSum(nestedList, 1);
    }

    private int calculateDepthSum(List<NestedInteger> nestedList, int depth) {
        if (nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum += depth * nestedInteger.getInteger();
            } else {
                sum += calculateDepthSum(nestedInteger.getList(), depth + 1);
            }
        }
        return sum;
    }
}

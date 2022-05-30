package Coding.BFS;

// https://leetcode.com/problems/nested-list-weight-sum/
public class NestedListWeightSum {
//    public int depthSum(List<NestedInteger> nestedList) {
//        Queue<NestedInteger> queue = new LinkedList<>();
//        queue.addAll(nestedList);
//        int result = 0;
//        int level = 1;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                NestedInteger nestedInteger = queue.poll();
//                if (nestedInteger.isInteger()) {
//                    result += (nestedInteger.getInteger() * level);
//                } else {
//                    queue.addAll(nestedInteger.getList());
//                }
//            }
//            level++;
//        }
//        return result;
//    }
}

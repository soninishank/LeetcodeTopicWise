package Meta;

import java.util.ArrayList;
import java.util.List;

// Meta
public class MergeIntervals {
    public static List<int[]> mergeIntervals(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();

        while (i < A.length || j < B.length) {
            int[] curr = null;

            // This will happen when you have already traversed one list so you point to another list
            if (i == A.length) {
                curr = B[j];
                j++;
            } else if (j == B.length) {
                curr = A[i];
                i++;
            } else if (A[i][0] < B[j][0]) { // choose the smaller one based on start
                curr = A[i];
                i++;
            } else {
                curr = B[j];
                j++;
            }
            // Update the previousOne if its overlap by comparing previousEnd, currentStart
            if (!res.isEmpty() && res.get(res.size() - 1)[1] >= curr[0]) {
                int previousLast = res.get(res.size() - 1)[1];
                int currentLast = curr[1];
                // update previousLast
                res.get(res.size() - 1)[1] = Math.max(previousLast, currentLast);
            } else {
                res.add(curr);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] list1 = {{1, 5}, {10, 14}, {16, 18}};
        int[][] list2 = {{2, 6}, {8, 10}, {11, 20}};
        int[][] list3 = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] list4 = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] list5 = {{0, 10}};
        int[][] list6 = {{25, 226}};

//        System.out.println("list1 & list2");
//        printResult(mergeIntervals(list1, list2));
//
//        System.out.println("list3 & list4");
//        printResult(mergeIntervals(list3, list4));
//
//        System.out.println("list5 & list6");
//        printResult(mergeIntervals(list5, list6));


        int[][] list01 = {{1, 2}, {3, 9}};
        int[][] list02 = {{4, 6}, {8, 10}, {11, 12}};
        printResult(mergeIntervals(list01, list02));


    }

    private static void printResult(List<int[]> result) {
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}

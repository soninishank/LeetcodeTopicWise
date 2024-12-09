package Coding.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Two Pointer
// Meta
// 986. Interval List Intersections
// https://leetcode.com/problems/interval-list-intersections/
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int[] poll1 = firstList[i];
            int[] poll2 = secondList[j];
            int temp1 = Math.max(poll1[0], poll2[0]); // max
            int temp2 = Math.min(poll1[1], poll2[1]); // min
            if (temp1 <= temp2) {
                list.add(new int[]{temp1, temp2});
            }
            // compare last index
            if (poll1[1] <= poll2[1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] ints = new IntervalListIntersections().intervalIntersection(firstList, secondList);
        System.out.println(Arrays.deepToString(ints));
    }
}

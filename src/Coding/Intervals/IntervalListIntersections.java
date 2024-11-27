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
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);
            // we are adding only when low is less than high
            if (low <= high) {
                list.add(new int[]{low, high}); // if low is less than equal to high, it means it's a valid intersection
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;// move the pointer of a smaller one
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

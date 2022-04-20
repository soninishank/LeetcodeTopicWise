package Intervals;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/non-overlapping-intervals/
// easy question - after sort
public class NonOverlappingIntervals {
    private int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int result = 0;
        int newInterval[] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (newInterval[1] > intervals[i][0]) { // overlap  newInterval-> {1,2} currentInterval -> {1,3}
                result++;
            } else {
                newInterval[1] = intervals[i][1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] interval = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int i = new NonOverlappingIntervals().eraseOverlapIntervals(interval);
        System.out.println(i);
    }
}

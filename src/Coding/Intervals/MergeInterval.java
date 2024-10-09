package Coding.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // sort by start index
        List<int[]> mergeIntervalList = new ArrayList<>();
        int[] newInterval = intervals[0];
        mergeIntervalList.add(newInterval);

        // Iterate over all the intervals
        for (int i = 1; i < intervals.length; i++) {
            int first = intervals[i][0];
            int second = intervals[i][1];

            // If the intervals overlap, merge them by updating the end time
            if (newInterval[1] >= first) {
                newInterval[1] = Math.max(newInterval[1], second); // directly updating the reference in a list
            } else {
                // If they don't overlap, add the current interval to the list
                mergeIntervalList.add(intervals[i]);
                newInterval = intervals[i];
            }
        }
        return mergeIntervalList.toArray(new int[mergeIntervalList.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = new MergeInterval().merge(arr);
        System.out.println(Arrays.deepToString(merge));
    }
}

package Coding.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/insert-interval/
// There are three variation of this
// consider two variable - one is the currently passed temp variable and newInterval
// current = {1,2} newInterval = {4,8} ->  current[1] < newInterval[0]
// current = {12,16} newInterval = {3,10} -> current[0] > newInterval[1] -> newInterval - current
public class InsertInterval {
    // sorted in ascending order by starting - given in question
    // Run example 2 on this
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        // Add all intervals that come before the new interval (non-overlapping)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        // Add all remaining intervals after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] insert = new InsertInterval().insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(insert));
    }
}

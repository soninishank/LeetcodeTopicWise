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
    // sorted in ascending order by starti - given in question
    // Run example 2 on this
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            // currentInterval -> [1,2]
            // newInterval -> [4,8]
            // 2 < 4
            if (interval[1] < newInterval[0]) {
                // No overlap, current interval ends before new interval starts
                result.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // No overlap, current interval starts after new interval ends
                result.add(newInterval);
                newInterval = interval; // Now, newInterval should be considered as the current interval
            } else {
                // Overlapping intervals, merge them
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        // Add the final newInterval
        result.add(newInterval);

        // Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] insert = new InsertInterval().insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(insert));
    }
}

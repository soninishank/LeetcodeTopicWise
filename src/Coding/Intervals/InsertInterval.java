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
    public List<int[]> insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            resultList.add(intervals[i]);
            i++;
        }
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        resultList.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.length) {
            resultList.add(intervals[i]);
            i++;
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] insert = new InsertInterval().insert(intervals, newInterval).toArray(new int[0][]);
        System.out.println(Arrays.deepToString(insert));
    }
}

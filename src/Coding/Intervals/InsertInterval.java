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
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int length = intervals.length;
        // newInterval se chote jo bhi hai
        while (i < length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        // bich ke jo merge honge
        while (i < length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        // remaining interval
        while (i < length) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] insert = new InsertInterval().insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(insert));
    }
}

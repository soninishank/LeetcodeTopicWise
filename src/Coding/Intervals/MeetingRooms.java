package Coding.Intervals;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/meeting-rooms/
public class MeetingRooms {
    private boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] newInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (newInterval[1] > intervals[i][0]) {
                return false;
            } else {
                newInterval = intervals[i];
            }
        }
        return true;
    }
}

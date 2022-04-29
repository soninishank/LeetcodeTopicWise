package Coding.Intervals;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms-ii/
// similar like minimum number of platforms
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int[] arrival = new int[intervals.length];
        int[] dept = new int[intervals.length];
        int i = 0;
        for (int[] arr : intervals) {
            arrival[i] = arr[0];
            dept[i] = arr[1];
            i++;
        }
        Arrays.sort(arrival);
        Arrays.sort(dept);
        return getTotalMeetingRooms(arrival, dept);
    }

    private int getTotalMeetingRooms(int[] arrival, int[] dept) {
        int confRoom = 1;
        int i = 1, j = 0;
        int result = confRoom;
        while (i < arrival.length && j < dept.length) {
            if (arrival[i] < dept[j]) {
                i++;
                confRoom++;
            } else {
                j++;
                confRoom--;
            }
            result = Math.max(result, confRoom);
        }
        return result;
    }
}

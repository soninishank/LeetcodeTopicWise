package Coding.Intervals;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms-ii/
// similar like minimum number of platforms
// O(NlogN)
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
        return minNoOfMeetingRooms(arrival, dept);
    }

    private int minNoOfMeetingRooms(int[] arrival, int[] departure) {
        int i = 0;
        int j = 0;
        int rooms = 0;
        int maxRooms = 0;
        while (i < arrival.length && j < departure.length) {
            if (arrival[i] < departure[j]) {
                rooms++;
                i++;
                maxRooms = Math.max(maxRooms, rooms);
            } else {
                j++;
                rooms--;
            }
        }
        return maxRooms;
    }
}

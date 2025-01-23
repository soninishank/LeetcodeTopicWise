package Coding.Amazon.ProblemSolving;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _3_MeetingRoomsII {
    public int minMeetingRoomsUsingPQ(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // Use a min-heap to track the end time of ongoing meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Add the first meeting's end time to the heap
        minHeap.add(intervals[0][1]);
        // Iterate over the remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the room due to free up the earliest is free, remove it from the heap
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            // Add the current meeting's end time to the heap
            minHeap.add(intervals[i][1]);
        }
        // The size of the heap is the number of rooms required
        return minHeap.size();
    }

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

package Coding.Amazon.ProblemSolving;

import java.util.*;

// https://leetcode.com/problems/the-skyline-problem/
// https://chatgpt.com/c/678a08ed-6024-8008-ba73-ef99e05165bd
public class SkylineProblem {
    // Class to represent events
    static class Event implements Comparable<Event> {
        int x; // x-coordinate
        int height; // height of the building (positive for start, negative for end)

        Event(int x, int height) {
            this.x = x;
            this.height = height;
        }

        @Override
        public int compareTo(Event other) {
            // Sort primarily by x
            if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            }
            // If x is the same, sort start (-height) before end (+height)
            return Integer.compare(this.height, other.height);
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        // Step 1: Create a list of events
        List<Event> events = new ArrayList<>();
        for (int[] building : buildings) {
            events.add(new Event(building[0], -building[2])); // start of building
            events.add(new Event(building[1], building[2]));  // end of building
        }

        // Step 2: Sort the events
        Collections.sort(events);

        // Step 3: Max-heap to keep track of building heights
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.add(0); // Ground level

        // Result list to store the key points
        List<int[]> result = new ArrayList<>();
        int prevMaxHeight = 0;

        // Step 4: Process each event
        for (Event event : events) {
            if (event.height < 0) {
                // Start of a building, add height to the heap
                maxHeap.add(-event.height);
            } else {
                // End of a building, remove height from the heap
                maxHeap.remove(event.height);
            }

            // Get the current maximum height
            int currMaxHeight = maxHeap.peek();
            if (currMaxHeight != prevMaxHeight) {
                // If the max height changes, add a new key point
                result.add(new int[]{event.x, currMaxHeight});
                prevMaxHeight = currMaxHeight;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SkylineProblem skyline = new SkylineProblem();

        // Example input
        int[][] buildings = {
                {0, 2, 3}, // L,R,H   0 to 2 is left to right and height is 3
                {1, 5, 2} // L,R,H    1 to 5 is left to right and height is 2
        };

        // Get the skyline
        List<int[]> result = skyline.getSkyline(buildings);

        // Print the result
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}
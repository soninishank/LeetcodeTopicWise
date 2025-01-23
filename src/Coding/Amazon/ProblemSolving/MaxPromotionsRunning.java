package Coding.Amazon.ProblemSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxPromotionsRunning {

    public int maxPromotionsRunning(List<int[]> promotions) {
        // Create a list of events: +1 for start, -1 for end
        List<int[]> events = new ArrayList<>();
        // we are adding +1 and -1 to track of start and end events
        for (int[] promotion : promotions) {
            events.add(new int[]{promotion[0], 1});  // Start of a promotion
            events.add(new int[]{promotion[1], -1}); // End of a promotion
        }

        // Sort events by time, with end events (-1) processed before start events (+1) if times are equal
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                // This ensures that promotions ending at a given time do not count as overlapping with
                // new promotions starting at the same time
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // Sweep line to find the maximum number of overlapping promotions
        int maxRunning = 0;
        int currentRunning = 0;

        for (int[] event : events) {
            currentRunning += event[1]; // Add +1 for start, -1 for end
            maxRunning = Math.max(maxRunning, currentRunning);
        }

        return maxRunning;
    }

    public static void main(String[] args) {
        // Example usage
        List<int[]> promotions = new ArrayList<>();
        promotions.add(new int[]{1, 3});
        promotions.add(new int[]{2, 5});
        promotions.add(new int[]{5, 9});

        System.out.println(new MaxPromotionsRunning().maxPromotionsRunning(promotions));  // Output: 2
    }
}

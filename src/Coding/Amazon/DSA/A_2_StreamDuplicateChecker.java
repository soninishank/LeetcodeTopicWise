package Coding.Amazon.DSA;

import java.util.*;

public class A_2_StreamDuplicateChecker {
    private HashSet<Integer> hashSet;
    private Queue<Integer> slidingWindow;
    private int k;

    public A_2_StreamDuplicateChecker(int k) {
        this.hashSet = new HashSet<>();
        this.slidingWindow = new LinkedList<>();
        this.k = k;
    }

    public boolean processFrame(int frame) {
        // Check if the frame is a duplicate
        if (hashSet.contains(frame)) {
            return true; // Duplicate found
        }

        // Add the current frame to the sliding window and HashSet
        slidingWindow.offer(frame);
        hashSet.add(frame);

        // If the window exceeds size K, remove the oldest frame
        if (slidingWindow.size() > k) {
            int oldest = slidingWindow.poll();
            hashSet.remove(oldest);
        }
        return false; // No duplicate
    }


    /**
     * Process a stream of video frames and return a list of duplicates found.
     *
     * @param stream The stream of video frames.
     * @return A list of duplicate frames found.
     */
    public List<Integer> findDuplicatesInStream(List<Integer> stream) {
        List<Integer> duplicates = new ArrayList<>();

        for (int frame : stream) {
            if (processFrame(frame)) {
                duplicates.add(frame); // Add the duplicate frame to the list
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        // Initialize the checker with a window size of K
        int k = 3;
        A_2_StreamDuplicateChecker checker = new A_2_StreamDuplicateChecker(k);

        // Example stream of video frames
        List<Integer> stream = Arrays.asList(1, 2, 3, 1, 4, 5, 3, 6, 4);

        // Find duplicates
        List<Integer> duplicates = checker.findDuplicatesInStream(stream);

        // Output the duplicates
        System.out.println("Duplicates: " + duplicates);
    }
}

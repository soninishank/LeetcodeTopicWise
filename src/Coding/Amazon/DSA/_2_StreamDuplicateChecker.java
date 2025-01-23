package Coding.Amazon.DSA;

import java.util.*;

public class _2_StreamDuplicateChecker {
    public List<Integer> findRepeatedElements(Stream stream, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> slidingWindow = new LinkedList<>();
        Set<Integer> windowSet = new HashSet<>(); // window Set, it is used for checking duplicates is O(1)

        while (stream.hasNext()) {
            int current = stream.next();

            // Check if the current element is in the last k frames
            if (windowSet.contains(current)) {
                result.add(current);
            }

            // Update the sliding window
            slidingWindow.add(current);
            windowSet.add(current);
            if (slidingWindow.size() > k) {
                int removed = slidingWindow.poll();
                if (!slidingWindow.contains(removed)) { //Do not modify windowSet if the element is already present.
                    windowSet.remove(removed);
                }
            }
        }
        return result;
    }

    // Main Method
    public static void main(String[] args) {
        // Input: Stream and k value
        List<Integer> inputStream = Arrays.asList(1, 2, 3, 4, 2, 1, 1, 2, 4);
        int k = 4;
        Stream stream = new MockStream(inputStream);
        _2_StreamDuplicateChecker codec = new _2_StreamDuplicateChecker();
        List<Integer> result = codec.findRepeatedElements(stream, k);
        System.out.println("Output: " + result);
    }

    static class MockStream implements Stream {
        private final List<Integer> elements;
        private int index = 0;

        public MockStream(List<Integer> elements) {
            this.elements = elements;
        }

        @Override
        public Boolean hasNext() {
            return index < elements.size();
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return elements.get(index++);
            }
            throw new NoSuchElementException("End of stream");
        }
    }
}

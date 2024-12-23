package Meta;

import java.util.PriorityQueue;

// https://leetcode.com/discuss/interview-question/361164/facebook-phone-screen-mth-smallest-left-most-index-of-1
public class FindKthSmallestValueAmongMArrays_8 {
    public static int findMthSmallest(int[][] sortedArrays, int m) {
        // Min-heap to store elements as (value, arrayIndex, elementIndex)
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        // Initialize the heap with the first element of each array
        for (int i = 0; i < sortedArrays.length; i++) {
            if (sortedArrays[i].length > 0) {
                minHeap.offer(new Element(sortedArrays[i][0], i, 0));
            }
        }
        int count = 0;
        while (!minHeap.isEmpty()) {
            // Extract the smallest element from the heap
            Element current = minHeap.poll();
            count++;

            // If we've extracted m elements, return the current value
            if (count == m) {
                return current.value;
            }

            // If there is another element in the same array, push it into the heap
            if (current.elementIndex + 1 < sortedArrays[current.arrayIndex].length) {
                int nextValue = sortedArrays[current.arrayIndex][current.elementIndex + 1];
                minHeap.offer(new Element(nextValue, current.arrayIndex, current.elementIndex + 1));
            }
        }

        // If we exhaust the heap before finding m elements
        throw new IllegalArgumentException("m is larger than the total number of elements in the arrays");
    }

    public static void main(String[] args) {
        int[][] sortedArrays = {{1, 3}, {2, 4, 6}, {0, 9, 10, 11}};
        int m = 5;

        try {
            int result = findMthSmallest(sortedArrays, m);
            System.out.println("Output: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Element {
    int value;
    int arrayIndex;
    int elementIndex;

    public Element(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

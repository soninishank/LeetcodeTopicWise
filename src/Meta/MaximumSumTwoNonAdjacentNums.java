package Meta;

import java.util.Comparator;
import java.util.PriorityQueue;

// Given an array, find the maximum sum of any two non-adjacent numbers.
// Given an array of at least 3 numbers, find the maximum sum of any two elements which are not adjacent.
//Can the array be empty? No, the description says minimum of 3.
//Can there be negative numbers? Yes.
//Can there be duplicate numbers? Yes.
public class MaximumSumTwoNonAdjacentNums {
    public static int maxSumOfNonAdjacentPair(int[] array) {
        // Ensure the array has at least 3 elements
        if (array.length < 3) {
            throw new IllegalArgumentException("Array must have at least 3 elements.");
        }
        int maxNonAdjacent = array[0];
        int maxSum = array[0] + array[2];

        for (int i = 3; i < array.length; i++) {
            maxNonAdjacent = Math.max(maxNonAdjacent, array[i - 2]);
            maxSum = Math.max(maxSum, maxNonAdjacent + array[i]);
        }
        return maxSum;
    }


    public static int maxSumOfNonAdjacentPairUsingHeap(int[] array) {
        if (array.length < 3) {
            throw new IllegalArgumentException("Array must have at least 3 elements.");
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // sort by value
        for (int i = 0; i < array.length; i++) {
            minHeap.offer(new int[]{array[i], i}); // Add value and index as a pair
            if (minHeap.size() > 4) {
                minHeap.poll(); // Keep only the top 4 largest elements
            }
        }
        int[][] topFourElements = minHeap.toArray(new int[0][]);
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < topFourElements.length; i++) {
            for (int j = 0; j < topFourElements.length; j++) {
                if (i != j && Math.abs(topFourElements[i][1] - topFourElements[j][1]) >= 2) {
                    maxSum = Math.max(maxSum, topFourElements[i][0] + topFourElements[j][0]);
                }
            }
        }
        return maxSum;
    }
}

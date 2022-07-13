package Coding.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Merge k sorted arrays of different size
// https://leetcode.com/discuss/interview-question/617596/facebook-onsite-merge-k-sorted-arrays
public class MergeKSortedArrays {
    public int[] mergekSortedArrays(int[][] arrays) {
        int result = 0;
        PriorityQueue<RowIndex> priorityQueue = new PriorityQueue<>(new Comparator<RowIndex>() {
            @Override
            public int compare(RowIndex o1, RowIndex o2) {
                return o1.value - o2.value;
            }
        });
        for (int i = 0; i < arrays.length; i++) {
            result += arrays[i].length;
            priorityQueue.add(new RowIndex(i, 0, arrays[i][0]));
        }
        int[] finalArray = new int[result];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            RowIndex poll = priorityQueue.poll();
            finalArray[i] = poll.value;
            i++;
            if (poll.index + 1 < arrays[poll.rowNo].length) {
                priorityQueue.add(new RowIndex(poll.rowNo, poll.index + 1, arrays[poll.rowNo][poll.index + 1]));
            }
        }
        return finalArray;
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 3},
                {2, 4, 6},
                {0, 9, 10, 11}};
        int[] ints = new MergeKSortedArrays().mergekSortedArrays(arr);
        System.out.println(Arrays.toString(ints));
    }
}

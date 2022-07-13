package Coding.PriorityQueue.K;

import Coding.PriorityQueue.RowIndex;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<RowIndex> priorityQueue = new PriorityQueue<>(new Comparator<RowIndex>() {
            @Override
            public int compare(RowIndex o1, RowIndex o2) {
                return o1.value - o2.value;
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            priorityQueue.add(new RowIndex(i, 0, matrix[i][0]));
        }
        while (k - 1 > 0) {
            RowIndex poll = priorityQueue.poll();
            if (poll.index + 1 < matrix.length) {
                priorityQueue.add(new RowIndex(poll.rowNo, poll.index + 1, matrix[poll.rowNo][poll.index + 1]));
            }
            k--;
        }
        return priorityQueue.peek().value;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int i = new KthSmallestElementInSortedMatrix().kthSmallest(matrix, 8);
        System.out.println(i);
    }
}

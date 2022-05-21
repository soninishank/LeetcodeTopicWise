package Coding.Matrix;

import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                priorityQueue.add(matrix[i][j]);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }
        return priorityQueue.poll();
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int i = new KthSmallestElementSortedMatrix().kthSmallest(arr, 8);
        System.out.println(i);
    }
}

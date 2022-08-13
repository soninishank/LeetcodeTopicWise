package Coding.Graph.KahnAlgoTopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCoursesIII {
    List<List<Integer>> adjList = new ArrayList<>();

    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] incomingEdges = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] arr : relations) {
            incomingEdges[arr[1]]++;
            adjList.get(arr[0]).add(arr[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }
        int maxMonths = 0;
        while (!queue.isEmpty()) {
            int sum = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                sum = Math.max(sum, time[poll - 1]);
                for (int neighbour : adjList.get(poll)) {
                    incomingEdges[neighbour]--;
                    if (incomingEdges[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
            maxMonths += sum;
        }
        return maxMonths;
    }

    public static void main(String[] args) {
        int i = new ParallelCoursesIII().minimumTime(5, new int[][]{{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}}, new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
    }
}

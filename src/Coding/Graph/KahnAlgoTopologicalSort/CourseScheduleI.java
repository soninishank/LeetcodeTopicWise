package Coding.Graph.KahnAlgoTopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule/
public class CourseScheduleI {

    List<List<Integer>> adjList = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] arr : prerequisites) {
            incomingEdges[arr[0]]++;
            adjList.get(arr[1]).add(arr[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }
        int edgeCnt = prerequisites.length;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbour : adjList.get(current)) {
                edgeCnt--;
                incomingEdges[neighbour]--;
                if (incomingEdges[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return edgeCnt == 0;
    }


    public static void main(String[] args) {
        int numCourses = 5, prerequisites[][] = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        boolean b = new CourseScheduleI().canFinish(numCourses, prerequisites);
        System.out.println(b);
    }
}
//
//   1 -> 4
package Coding.Graph.KahnAlgoTopologicalSort;

import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/
// similar like course schedule I
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create adjacency list
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        // Build data in adjList
        for (int[] arr : prerequisites) {
            int v = arr[0];
            int u = arr[1];
            adjList.get(u).add(v);
        }
        // Build inDegree
        int[] inDegree = new int[numCourses];
        for (int[] arr : prerequisites) {
            int v = arr[0];
            int u = arr[1];
            inDegree[v]++;
        }
        // Now create a queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        // Now iterate over a queue
        while (!queue.isEmpty()) {
            int num = queue.poll();
            result.add(num); // add it in the result
            for (int neighbour : adjList.get(num)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        if (result.size() == numCourses) {
            int[] finalList = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                finalList[i] = result.get(i);
            }
            return finalList;
        } else {
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = new CourseScheduleII().findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }
}

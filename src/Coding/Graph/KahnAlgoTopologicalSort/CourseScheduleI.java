package Coding.Graph.KahnAlgoTopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule/
public class CourseScheduleI {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // Array to track the in-degree (number of prerequisites) of each course
        int[] inDegree = new int[numCourses];
        // Build the graph and in-degree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            inDegree[course]++;
        }
        // Use a queue to perform BFS
        Queue<Integer> queue = new LinkedList<>();
        // Add courses with in-degree 0 (no prerequisites) to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // Track the number of courses that can be completed
        int completedCourses = 0;
        // Process courses in topological order
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;
            // For each neighbor (dependent course), reduce the in-degree
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                // If in-degree becomes 0, add the course to the queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        // If all courses are completed, return true
        return completedCourses == numCourses;
    }


    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        boolean b = new CourseScheduleI().canFinish(numCourses, prerequisites);
        System.out.println(b);
    }
}
//
//   1 -> 4
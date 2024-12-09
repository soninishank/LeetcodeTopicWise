package Coding.Graph.KahnAlgoTopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCourses {
    // Adjacency list to represent the graph
    List<List<Integer>> adjList = new ArrayList<>();

    public int minimumSemesters(int n, int[][] relations) {
        // Step 1: Initialize incoming edges array and adjacency list
        int[] incomingEdges = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Step 2: Build the graph
        for (int[] relation : relations) {
            int prerequisite = relation[0];
            int course = relation[1];
            incomingEdges[course]++; // Increment indegree of the dependent course
            adjList.get(prerequisite).add(course); // Add edge to an adjacency list
        }

        // Step 3: Initialize queue with courses having no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i); // Courses with no prerequisites
            }
        }

        // Step 4: Process the graph using BFS
        int semesters = 0; // Count of levels (semesters)
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all courses for the current semester
            for (int i = 0; i < size; i++) {
                int course = queue.poll();
                n--; // Reduce the number of remaining courses

                // Reduce the indegree of all neighbors
                for (int neighbor : adjList.get(course)) {
                    incomingEdges[neighbor]--;
                    if (incomingEdges[neighbor] == 0) {
                        queue.add(neighbor); // Add courses ready to be taken
                    }
                }
            }
            semesters++; // Increment semester count
        }

        // Step 5: Check for cycles
        return n == 0 ? semesters : -1; // Return -1 if a cycle exists
    }


    public static void main(String[] args) {
        int i = new ParallelCourses().minimumSemesters(3, new int[][]{{1, 3}, {2, 3}});
        System.out.println(i);
    }
}

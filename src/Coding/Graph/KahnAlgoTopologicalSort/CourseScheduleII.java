package Coding.Graph.KahnAlgoTopologicalSort;

import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/
// similar like course schedule I
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        int[] topologicalOrder = new int[numCourses];


        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
            inDegree.put(i, 0);
        }
        // Create the adjacency list representation of the graph
        for (int[] prerequisite : prerequisites) {
            int destination = prerequisite[0];
            int source = prerequisite[1];
            adjList.get(destination).add(source);
            inDegree.put(source, inDegree.getOrDefault(source, 0) + 1);
        }
        // Find inDegree with value 0
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        // Iterate queue with inDegree 0
        int index = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            topologicalOrder[index] = poll;
            index++;
            // check neighbouring nodes
            for (Integer child : adjList.get(poll)) {
                inDegree.put(child, inDegree.getOrDefault(child, 0) - 1); // reduce the indegree
                if (inDegree.get(child) == 0) {
                    queue.add(child);
                }
            }
        }
        // Check to see if topological sort is possible or not.
        if (index == numCourses) {
            return topologicalOrder;
        }
        return new int[0];// return 0 value
    }
}

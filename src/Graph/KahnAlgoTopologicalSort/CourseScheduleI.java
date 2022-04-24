package Graph.KahnAlgoTopologicalSort;

import java.util.*;

// Detect a cycle in graph
// https://leetcode.com/problems/course-schedule/
public class CourseScheduleI {

    List<Integer> resultTopologicalOrder = new ArrayList<>();

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        // create adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
            inDegree.put(i, 0);
        }
        // create inDegree map
        for (int[] prerequisite : prerequisites) {
            int parent = prerequisite[0];
            int child = prerequisite[1];
            adjList.get(parent).add(child);
            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            resultTopologicalOrder.add(poll);
            for (Integer child : adjList.get(poll)) {
                inDegree.put(child, inDegree.getOrDefault(child, 0) - 1);
                if (inDegree.get(child) == 0) {
                    queue.add(child);
                }
            }
        }
        if (resultTopologicalOrder.size() != numCourses) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 5, prerequisites[][] = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        boolean b = new CourseScheduleI().canFinish(numCourses, prerequisites);
        System.out.println(b);
    }
}

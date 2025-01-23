package Coding.Amazon.DSA;

import java.util.*;

// Topological order
// Time complexity - O(n+m)
// Space complexity - O(n+m)
public class A_9_JobScheduler {

    public static List<Integer> getJobOrder(List<Integer> jobs, List<int[]> deps) {
        // Step 1: Build the graph and in-degree map
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        // Initialize the graph and in-degree map
        for (int job : jobs) {
            graph.put(job, new ArrayList<>());
            inDegree.put(job, 0);
        }

        // Populate the graph and in-degree map based on dependencies
        for (int[] dep : deps) {
            int prereq = dep[0];
            int job = dep[1];
            graph.get(prereq).add(job);
            inDegree.put(job, inDegree.get(job) + 1);
        }

        // Step 2: Initialize the queue with jobs having no prerequisites (in-degree = 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int job : jobs) {
            if (inDegree.get(job) == 0) {
                queue.offer(job);
            }
        }

        // Step 3: Perform topological sorting
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currentJob = queue.poll();
            order.add(currentJob);

            // Reduce the in-degree of dependent jobs
            for (int dependent : graph.get(currentJob)) {
                inDegree.put(dependent, inDegree.get(dependent) - 1);
                if (inDegree.get(dependent) == 0) {
                    queue.offer(dependent);
                }
            }
        }

        // Step 4: Check if all jobs are processed
        if (order.size() == jobs.size()) {
            return order;
        } else {
            return new ArrayList<>(); // Return an empty list if there's a cycle
        }
    }

    public static void main(String[] args) {
        // Example input
        List<Integer> jobs = Arrays.asList(1, 2, 3, 4);
        List<int[]> deps = Arrays.asList(
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{3, 2},
                new int[]{4, 2},
                new int[]{4, 3}
        );

        // Get the job order
        List<Integer> jobOrder = getJobOrder(jobs, deps);

        // Print the result
        if (jobOrder.isEmpty()) {
            System.out.println("No valid job order exists (cycle detected).");
        } else {
            System.out.println("Valid job order: " + jobOrder);
        }
    }
}

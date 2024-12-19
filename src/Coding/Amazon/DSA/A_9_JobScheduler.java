package Coding.Amazon.DSA;

import java.util.*;

// Topological order
// Time complexity - O(n+m)
// Space complexity - O(n+m)
public class A_9_JobScheduler {
    public static List<Integer> getJobExecutionOrder(List<Integer> jobIds, List<int[]> jobDependencies) {
        // Step 1: Build the graph and in-degree map
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        // Initialize graph and in-degree for all jobs
        for (int jobId : jobIds) {
            adjList.put(jobId, new ArrayList<>());
            inDegree.put(jobId, 0);
        }
        // Add dependencies to the graph
        for (int[] dependency : jobDependencies) {
            int prerequisiteJob = dependency[0];
            int dependentJob = dependency[1];
            adjList.get(prerequisiteJob).add(dependentJob);
            inDegree.put(dependentJob, inDegree.get(dependentJob) + 1);
        }
        // Step 2: Add jobs with zero dependencies to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int jobId : inDegree.keySet()) {
            if (inDegree.get(jobId) == 0) {
                queue.add(jobId);
            }
        }
        // Step 3: Process jobs in topological order
        List<Integer> executionOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currentJob = queue.poll();
            executionOrder.add(currentJob);
            for (int dependentJob : adjList.get(currentJob)) {
                inDegree.put(dependentJob, inDegree.get(dependentJob) - 1);
                if (inDegree.get(dependentJob) == 0) {
                    queue.add(dependentJob);
                }
            }
        }
        // Step 4: Check for cycles
        if (executionOrder.size() != jobIds.size()) {
            return new ArrayList<>(); // Cycle detected, return empty list
        }
        return executionOrder;
    }


    public static void main(String[] args) {
        // Example Input
        List<Integer> jobs = Arrays.asList(1, 2, 3, 4);
        List<int[]> dependencies = Arrays.asList(new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 2}, new int[]{4, 2}, new int[]{4, 3});

        // Get a valid job order
        List<Integer> result = getJobExecutionOrder(jobs, dependencies);
        System.out.println(result); // Example Output: [1, 4, 3, 2] or [4, 1, 3, 2]
    }
}

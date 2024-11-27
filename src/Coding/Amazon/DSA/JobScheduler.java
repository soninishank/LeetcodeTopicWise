package Coding.Amazon.DSA;

import java.util.*;

public class JobScheduler {
    public static List<Integer> getJobOrder(List<Integer> jobs, List<int[]> deps) {
        // Step 1: Build the graph and in-degree map
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int job : jobs) {
            graph.put(job, new ArrayList<>());
            inDegree.put(job, 0);
        }

        for (int[] dep : deps) {
            int prereq = dep[0];
            int job = dep[1];
            graph.get(prereq).add(job);
            inDegree.put(job, inDegree.get(job) + 1);
        }

        // Step 2: Add jobs with zero in-degree to the queue
        Queue<Integer> zeroInDegree = new LinkedList<>();
        for (int job : inDegree.keySet()) {
            if (inDegree.get(job) == 0) {
                zeroInDegree.add(job);
            }
        }

        // Step 3: Process jobs in topological order
        List<Integer> jobOrder = new ArrayList<>();
        while (!zeroInDegree.isEmpty()) {
            int current = zeroInDegree.poll();
            jobOrder.add(current);

            for (int dependent : graph.get(current)) {
                inDegree.put(dependent, inDegree.get(dependent) - 1);
                if (inDegree.get(dependent) == 0) {
                    zeroInDegree.add(dependent);
                }
            }
        }

        // Step 4: Check for cycles
        if (jobOrder.size() != jobs.size()) {
            return new ArrayList<>(); // Cycle detected, return empty list
        }

        return jobOrder;
    }

    public static void main(String[] args) {
        // Example Input
        List<Integer> jobs = Arrays.asList(1, 2, 3, 4);
        List<int[]> deps = Arrays.asList(
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{3, 2},
                new int[]{4, 2},
                new int[]{4, 3}
        );

        // Get valid job order
        List<Integer> result = getJobOrder(jobs, deps);
        System.out.println(result); // Example Output: [1, 4, 3, 2] or [4, 1, 3, 2]
    }
}

package Coding.Amazon.ProblemSolving;

import java.util.*;

public class ProductCategories {
    // Helper function for DFS
    private static int dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited.add(node);
        int size = 0;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            size++;
            List<Integer> neighbors = graph.get(current);
            if (neighbors == null) {
                neighbors = new ArrayList<>();
            }
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        // Input: List of product pairs
        int[][] pairs = {{1, 5}, {7, 2}, {3, 4}, {4, 8}, {6, 3}, {5, 2}};

        // Step 1: Build the graph - bidirectional
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : pairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        // Step 2: Find connected components using DFS
        Set<Integer> visited = new HashSet<>();
        List<Integer> categorySizes = new ArrayList<>();

        for (int product : graph.keySet()) {
            if (!visited.contains(product)) {
                int size = dfs(graph, product, visited);
                categorySizes.add(size);
            }
        }

        // Step 3: Count pairs between categories
        int totalProducts = 0;
        for (int size : categorySizes) {
            totalProducts += size;
        }
        long totalPairs = 0;
        for (int size : categorySizes) {
            totalPairs += (long) size * (totalProducts - size);
        }
        totalPairs /= 2; // Each pair is counted twice

        // Output the results
        System.out.println("Number of categories: " + categorySizes.size());
        System.out.println("Sizes of categories: " + categorySizes);
        System.out.println("Number of valid product pairs: " + totalPairs);
    }
}


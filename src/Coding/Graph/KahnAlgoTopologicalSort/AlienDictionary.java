package Coding.Graph.KahnAlgoTopologicalSort;

import java.util.*;

// https://leetcode.com/problems/alien-dictionary/
public class AlienDictionary {
    public String alienOrder(String[] words) {
        // Step 1: Initialize graph and in-degree map
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize the in-degree map for each unique character
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
            }
        }

        // Step 2: Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLen = Math.min(word1.length(), word2.length());

            // Check for a prefix condition (invalid order)
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; // invalid order
            }

            // Find the first non-matching character and create an edge
            for (int j = 0; j < minLen; j++) {
                char parent = word1.charAt(j);
                char child = word2.charAt(j);
                if (parent != child) {
                    if (!graph.containsKey(parent)) {
                        graph.put(parent, new HashSet<>());
                    }
                    // Add the edge if it hasn't been added before
                    if (graph.get(parent).add(child)) {
                        inDegree.put(child, inDegree.get(child) + 1);
                    }
                    break; // only the first non-matching character matters
                }
            }
        }

        // Step 3: Topological sort using BFS (Kahn's Algorithm)
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        // Add all nodes with in-degree 0 to the queue
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            if (graph.containsKey(current)) {
                for (char neighbor : graph.get(current)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if (inDegree.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        // If result length is less than the number of unique characters, there was a cycle
        if (result.length() < inDegree.size()) {
            return ""; // invalid order (cycle detected)
        }

        return result.toString();
    }
}
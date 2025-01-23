package Coding.Rippling;

import java.util.*;

// https://leetcode.com/problems/evaluate-division
// https://leetcode.com/discuss/interview-question/483660/google-phone-currency-conversion
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Create a graph to represent equations
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        // Answer the queries
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0; // If one of the variables is not in the graph
            } else if (start.equals(end)) {
                results[i] = 1.0; // Division of the same variable
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, start, end, 1.0, visited);
            }
        }

        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double product,
                       Set<String> visited) {
        if (visited.contains(current)) {
            return -1.0;
        }
        if (current.equals(target)) {
            return product;
        }

        visited.add(current);

        Map<String, Double> neighbors = graph.get(current);
        for (String neighbor : neighbors.keySet()) {
            double result = dfs(graph, neighbor, target, product * neighbors.get(neighbor), visited);
            if (result != -1.0) {
                return result;
            }
        }
        visited.remove(current);
        return -1.0;
    }
}

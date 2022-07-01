package Coding.Graph.UnionFind;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/evaluate-division/
// 1. same number - exist in equations - a / a = 1
// 2. same number - not exist in equations - x / x = -1
// 3. reflection of a equation - b / a - 1/ value
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adjMap = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            Set<String> visited = new HashSet<>();
            // if both the keys are same
            if (query.get(0).equals(query.get(1))) {
                // if present in graph -- ["a","a"]
                if (adjMap.containsKey(query.get(0))) {
                    result[i] = 1.0;
                }// if not present in graph  -- ["x","x"]
                else {
                    result[i] = -1.0;
                }
            } else {
                result[i] = applyDFS(adjMap, query.get(0), query.get(1), visited);
            }
            i++;
        }
        return result;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int i = 0;
        for (List<String> equation : equations) {
            String source = equation.get(0);
            String destination = equation.get(1);
            double val = values[i];
            i++;

            // one side
            graph.putIfAbsent(source, new HashMap<>());
            graph.get(source).put(destination, val);
            // opposite side
            graph.putIfAbsent(destination, new HashMap<>());
            graph.get(destination).put(source, 1 / val);
        }
        return graph;
    }

    private double applyDFS(Map<String, Map<String, Double>> adjMap, String source, String destination, Set<String> visited) {
        if (!adjMap.containsKey(source)) {
            return -1.0;
        }
        // Found the value
        if (adjMap.get(source).containsKey(destination)) {
            return adjMap.get(source).get(destination);
        }
        visited.add(source);
        Map<String, Double> stringDoubleMap = adjMap.get(source);
        for (Map.Entry<String, Double> entry : stringDoubleMap.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                double currentValue = applyDFS(adjMap, entry.getKey(), destination, visited);
                if (currentValue != -1) {
                    return currentValue * entry.getValue();
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        String[][] dataSet = {{"a", "b"}, {"b", "c"}};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double values[] = {2.0, 3.0};
        List<List<String>> equations = Arrays.stream(dataSet).map(Arrays::asList).collect(Collectors.toList());
        List<List<String>> collect = Arrays.stream(queries).map(Arrays::asList).collect(Collectors.toList());
        double[] doubles = new EvaluateDivision().calcEquation(equations, values, collect);
        System.out.println(Arrays.toString(doubles));
    }
}

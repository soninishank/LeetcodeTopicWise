package Coding.Graph.Coloring;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/is-graph-bipartite/
// 2-D graph - no need of creating Adjacency List
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            // Not colored
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;

                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    for (int neighbour : graph[poll]) {
                        if (color[neighbour] == -1) {
                            color[neighbour] = color[poll] ^ 1; // 0
                            queue.add(neighbour);
                        } else if (color[neighbour] == color[poll]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        boolean bipartite = new IsGraphBipartite().isBipartite(arr);
        System.out.println(bipartite);
    }
}

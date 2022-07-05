package Coding.Graph.Coloring;

import java.util.*;

// we are creating adjacencyList because it starts from 1 not 0
// https://leetcode.com/discuss/interview-experience/751636/coupang-seattle-wa-july-2020-software-engineer
// https://leetcode.com/problems/possible-bipartition/
//Think of graph, node coloring, and DFS.
//Abstract model transformation:
//Person <-> Node
//P1 and P2 dislike each other <-> Node 1 and Node 2 share one edge, and they can be drawed with different two colors (i.e., for dislike relation)
//If we can draw each dislike pair with different two colors, and keep the dislike relationship always, then there exists at least one possible bipartition.
public class PossibleBipartition {
    // color - 0 - not colored
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color = new int[N + 1];
        Arrays.fill(color, -1);
        for (int i = 1; i <= N; i++) {
            // Not colored
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    for (int neighbour : dislikes[poll]) {
                        if (color[neighbour] == -1) {
                            color[neighbour] = color[poll] ^ 1;
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
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        boolean b = new PossibleBipartition().possibleBipartition(n, dislikes);
        System.out.println(b);
    }
}


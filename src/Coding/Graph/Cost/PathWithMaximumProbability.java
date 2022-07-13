package Coding.Graph.Cost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/path-with-maximum-probability/
public class PathWithMaximumProbability {


    public double maxProbability(int n, int[][] edges, double[] successProb, int start, int end) {
        List<List<Probability>> adjList = new ArrayList<>();
        // Build the adjacency matrix - directed
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        int i = 0;
        for (int[] c : edges) {
            adjList.get(c[0]).add(new Probability(c[1], successProb[i]));
            adjList.get(c[1]).add(new Probability(c[0], successProb[i]));
            i++;
        }
        double[] maximumCostArray = new double[n];
        Arrays.fill(maximumCostArray, Integer.MIN_VALUE);

        PriorityQueue<Probability> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        maxHeap.offer(new Probability(start, 1.0d));
        while (!maxHeap.isEmpty()) {
            Probability poll = maxHeap.poll();
            int currentSource = poll.destination;
            double currentCost = poll.probability;
            if (maximumCostArray[currentSource] >= 0) {
                continue;
            }
            maximumCostArray[currentSource] = currentCost;
            if (currentSource == end) {
                break;
            }
            for (Probability probability : adjList.get(currentSource)) {
                int neighbourDest = probability.destination;
                double neighbourCost = probability.probability;
                // if it's greater than
                if (maximumCostArray[neighbourDest] < maximumCostArray[currentSource] * neighbourCost) {
                    maxHeap.add(new Probability(neighbourDest, maximumCostArray[currentSource] * neighbourCost));
                }
            }
        }
        return maximumCostArray[end] >= 0 ? maximumCostArray[end] : 0;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        double v = new PathWithMaximumProbability().maxProbability(n, edges, succProb, 0, 2);
        System.out.println(v);
    }

    class Probability {
        int destination;
        double probability;

        public Probability(int destination, double probability) {
            this.destination = destination;
            this.probability = probability;
        }
    }
}

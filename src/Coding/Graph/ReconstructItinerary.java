package Coding.Graph;

import java.util.*;

// Hierholzer's algorithm for Eulerian circuits.
// https://leetcode.com/problems/reconstruct-itinerary/
// Eulerian Path
// adjList value is PriorityQueue because we want output in lexicographical order
// simple dfs & then removing every edge
// we need to add every element at first - starting backwards
// PriorityQueue ensures that the destinations for each departure are processed in lexicographical order.
// Using a PriorityQueue avoids the need for pre-sorting the tickets manually.
public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1: Build the graph
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }

        // Step 2: Perform DFS
        List<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);

        // Since we add nodes to the front in post-order, no need to reverse
        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll(); // Get the smallest lexical destination
            dfs(next, graph, itinerary);
        }
        itinerary.add(0, airport); // Add the airport to the front
    }

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("MUC", "LHR"));
        lists.add(Arrays.asList("JFK", "MUC"));
        lists.add(Arrays.asList("SFO", "SJC"));
        lists.add(Arrays.asList("LHR", "SFO"));
        List<String> itinerary = new ReconstructItinerary().findItinerary(lists);
        System.out.println(itinerary);
    }
}


// JFK -> ATL,SFO
// SFO -> ATL
// ATL -> JFK,SFO

// dfs("jfk") -
// DFS("ATL")
// DFS("JFK")
// DFS("SFO")
// DFS("ATL")
// DFS("SFO")

//jfk  > ATL-> JFK -> SFO -> ATL -> SFO  ( using linkedList addFirst)
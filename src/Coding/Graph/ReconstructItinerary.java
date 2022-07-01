package Coding.Graph;

import java.util.*;

// https://leetcode.com/problems/reconstruct-itinerary/
// Eulerian Path
// adjList value is PriorityQueue because we want output in lexicographical order
// simple dfs & then removing every edges
// we need to add every element at first - starting backwards
public class ReconstructItinerary {
    Map<String, PriorityQueue<String>> adjList;
    LinkedList<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        adjList = new HashMap<>();
        res = new LinkedList<>();

        //1. Build the graph
        for (List<String> ticket : tickets) {
            String source = ticket.get(0), destination = ticket.get(1);
            adjList.putIfAbsent(source, new PriorityQueue<>());
            adjList.get(source).offer(destination);
        }

        //2. Call dfs from JFK
        dfs("JFK");
        return res;
    }

    void dfs(String from) {
        PriorityQueue<String> arrivals = adjList.get(from);
        while (arrivals != null && arrivals.size() > 0) {
            dfs(arrivals.poll());
        }
        res.addFirst(from); // because eulerian path starts from source
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

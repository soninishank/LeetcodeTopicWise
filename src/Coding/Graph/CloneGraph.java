package Coding.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// It's very simple
// 1. Created a visited node
// 2. Connected elements of visited node to each other based on original graph - use the variable neighbour
// https://leetcode.com/problems/clone-graph/
// 133. Clone Graph
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        // Hash map to save the visited node, and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        HashMap<Node, Node> visited = new HashMap();

        // Put the first node in the queue
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        // Clone the node and put it in the visited dictionary.
        visited.put(node, new Node(node.val, new ArrayList<>()));

        // Start Coding.BFS traversal
        while (!queue.isEmpty()) {
            // Pop a node say "n" from the front of the queue.
            Node poll = queue.remove();
            // Iterate through all the neighbors of the node "n"
            for (Node neighbor : poll.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    // Add the newly encountered node to the queue.
                    queue.add(neighbor);
                }
                // We are connecting
                // Add the clone of the neighbor to the neighbors of the clone node "n".
                Node deepCopyNode = visited.get(poll);
                Node deepCopyNeighbourNode = visited.get(neighbor);
                deepCopyNode.neighbors.add(deepCopyNeighbourNode); // attach the neighbour
            }
        }
        // Return the clone of the node from visited.
        return visited.get(node); // this will return the value of deep copy node
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

package Coding.Graph.Directed;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
// https://www.youtube.com/watch?v=uzVUw90ZFIg
public class DetectCycleInDirectedGraph {
    
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[] = new boolean[V];
        boolean dfsVisited[] = new boolean[V];
        
        for(int i = 0 ; i < V ; i++)
        {
            // if not visited
            if(visited[i] == false)
            {
                if(isCycle(adj,visited,dfsVisited,i)) // if there is any cycle present 
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj,boolean visited[],boolean dfsVisited[],int current)
    {
        visited[current] = true;
        dfsVisited[current] = true;
        for(int child : adj.get(current))
        {
            if(visited[child] == false)
            {
                if(isCycle(adj,visited,dfsVisited,child))
                {
                   return true; 
                }
            }else if(dfsVisited[child])
            {
                return true;
            }
        }
        dfsVisited[current] = false;
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph();
        int[][] arr = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}};
        if (graph.isCyclic(arr, 4)) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't " + "contain cycle");
        }
    }


}

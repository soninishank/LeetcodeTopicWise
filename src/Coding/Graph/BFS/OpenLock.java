package Coding.Graph.BFS;

import java.util.*;

// https://leetcode.com/problems/open-the-lock/
public class OpenLock {
    // There are 8 possible traversal because from 0000 -> you can go down -1 , up + 1
    // 0001 , 0011 , 0111 , 1111, 9999, 0999, 0099, 0009
    // TC - O(10^4 * 8) = O(10000)
    // SC - O(10000)
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        // Edge case: if "0000" is a deadend
        if (deadSet.contains("0000")) return -1;
        // BFS initialization
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int steps = 0;
        // BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();
            // Process each state in the current level
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                // If we reach the target, return the number of steps
                if (current.equals(target)) {
                    return steps;
                }
                // Generate all possible next states (neighbors)
                for (String neighbor : getNeighbors(current)) {
                    if (!visited.contains(neighbor) && !deadSet.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            steps++;  // Increase the step count after processing the current level
        }
        // If we exit the loop, it's impossible to reach the target
        return -1;
    }

    // Helper function to generate all possible next states (neighbors) from the current state
    private List<String> getNeighbors(String current) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = current.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = chars[i];

            // Turn the wheel one step forward
            chars[i] = original == '9' ? '0' : (char) (original + 1);
            neighbors.add(new String(chars));

            // Turn the wheel one step backward
            chars[i] = original == '0' ? '9' : (char) (original - 1);
            neighbors.add(new String(chars));

            // Restore the original character
            chars[i] = original;
        }
        return neighbors;
    }

    public static void main(String[] args) {
        OpenLock solution = new OpenLock();

        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        System.out.println(solution.openLock(deadends, target));  // Output: 6
    }
}

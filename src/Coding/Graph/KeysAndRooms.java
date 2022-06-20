package Coding.Graph;

import java.util.*;

// https://leetcode.com/problems/keys-and-rooms/
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visitedNodes.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int val : rooms.get(poll)) {
                    if (!visitedNodes.contains(val)) {
                        visitedNodes.add(val);
                        queue.add(val);
                    }
                }
            }
        }
        return visitedNodes.size() == rooms.size();
    }

}

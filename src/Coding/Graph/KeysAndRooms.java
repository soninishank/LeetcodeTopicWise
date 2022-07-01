package Coding.Graph;

import java.util.*;

// https://leetcode.com/problems/keys-and-rooms/
// Room 0 is not locked , all other rooms are locked
// Room contains the keys of other rooms,
// so you just need to start from room 0 and keep going to those rooms which you have found the keys
// at last you can check if you have visited all the rooms - return true else false
// it can be done by using DFS also - if you have more than one connected component than you can't visit that
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


    public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        if (rooms.size() == 0) {
            return true;
        }
        HashSet<Integer> visited = new HashSet<>();
        return applyDFS(rooms, 0, visited) && visited.size() == rooms.size();
    }

    private boolean applyDFS(List<List<Integer>> rooms, int source, HashSet<Integer> visited) {
        if (visited.contains(source)) {
            return false;
        }
        visited.add(source);
        for (int neighbours : rooms.get(source)) {
            applyDFS(rooms, neighbours, visited);
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 3));
        lists.add(Arrays.asList(3, 0, 1));
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(0));
        boolean b = new KeysAndRooms().canVisitAllRoomsDFS(lists);
        System.out.println(b);
    }

}

package Coding.Graph;

import java.util.*;

public class TimeNeededToInformAllEmployees {

    HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();

    int totalTimeRequired = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                continue;
            } else {
                adjMap.putIfAbsent(manager[i], new ArrayList<>());
                adjMap.get(manager[i]).add(i);
            }
        }
        calculateTotalTimeNeeded(headID, adjMap, informTime, 0);
        return totalTimeRequired;
    }

    private void calculateTotalTimeNeeded(int headID, HashMap<Integer, ArrayList<Integer>> adjMap, int[] informTime, int time) {
        if (informTime[headID] == 0) {
            return;
        }
        time = time + informTime[headID];
        if (!adjMap.containsKey(headID)) {
            return;
        }
        for (int val : adjMap.get(headID)) {
            calculateTotalTimeNeeded(val, adjMap, informTime, time);
            totalTimeRequired = Math.max(totalTimeRequired, time);
        }
    }

    public static void main(String[] args) {
        int i = new TimeNeededToInformAllEmployees().numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0});
        System.out.println(i);
    }
}

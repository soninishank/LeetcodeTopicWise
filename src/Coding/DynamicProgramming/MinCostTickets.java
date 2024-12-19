package Coding.DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinCostTickets {

    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }

        int lastDay = 0;
        for (int day : days) {
            lastDay = Math.max(lastDay, day);
        }
        int[] memo = new int[lastDay + 1]; // Size memo based on lastDay
        Arrays.fill(memo, -1);

        return minCostRecursive(days, costs, daySet, 1, lastDay, memo);
    }

    private int minCostRecursive(int[] days, int[] costs, Set<Integer> daySet, int currentDay, int lastDay, int[] memo) {
        if (currentDay > lastDay) {
            return 0;
        }

        if (memo[currentDay] != -1) {
            return memo[currentDay];
        }

        if (daySet.contains(currentDay)) {
            int result = minCostRecursive(days, costs, daySet, currentDay + 1, lastDay, memo);
            memo[currentDay] = result;
            return result;
        }

        int cost1 = costs[0] + minCostRecursive(days, costs, daySet, currentDay + 1, lastDay, memo);
        int cost7 = costs[1] + minCostRecursive(days, costs, daySet, currentDay + 7, lastDay, memo);
        int cost30 = costs[2] + minCostRecursive(days, costs, daySet, currentDay + 30, lastDay, memo);

        int minCost = Math.min(cost1, Math.min(cost7, cost30));
        memo[currentDay] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        MinCostTickets s = new MinCostTickets();
        int[] days1 = {1, 4, 6, 7, 8, 20};
        int[] costs1 = {2, 7, 15};
        System.out.println(s.mincostTickets(days1, costs1));

        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs2 = {2, 7, 15};
        System.out.println(s.mincostTickets(days2, costs2));
    }
}

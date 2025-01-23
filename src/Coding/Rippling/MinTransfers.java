package Coding.Rippling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinTransfers {

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balanceMap = new HashMap<>();

        // Calculate net balance for each person
        for (int[] transaction : transactions) {
            int from = transaction[0], to = transaction[1], amount = transaction[2];
            balanceMap.put(from, balanceMap.getOrDefault(from, 0) - amount);
            balanceMap.put(to, balanceMap.getOrDefault(to, 0) + amount);
        }

        // Filter out zero balances
        List<Integer> balances = new ArrayList<>();
        for (int balance : balanceMap.values()) {
            if (balance != 0) balances.add(balance);
        }

        return settleDebt(balances, 0);
    }

    private int settleDebt(List<Integer> balances, int start) {
        // Skip already settled debts
        while (start < balances.size() && balances.get(start) == 0) {
            start++;
        }

        // If all debts are settled
        if (start == balances.size()) return 0;

        int minTransactions = Integer.MAX_VALUE;
        for (int i = start + 1; i < balances.size(); i++) {
            // If balances[start] and balances[i] can cancel each other
            if (balances.get(start) * balances.get(i) < 0) {
                // Try to settle the debt
                balances.set(i, balances.get(i) + balances.get(start));
                minTransactions = Math.min(minTransactions, 1 + settleDebt(balances, start + 1));
                // Backtrack
                balances.set(i, balances.get(i) - balances.get(start));
            }
        }

        return minTransactions;
    }

    public static void main(String[] args) {
        MinTransfers solution = new MinTransfers();
        int[][] transactions1 = {{0, 1, 10}, {2, 0, 5}};
        System.out.println(solution.minTransfers(transactions1)); // Output: 2

        int[][] transactions2 = {{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};
        System.out.println(solution.minTransfers(transactions2)); // Output: 1
    }

}

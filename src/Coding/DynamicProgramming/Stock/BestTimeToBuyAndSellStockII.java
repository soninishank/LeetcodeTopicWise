package Coding.DynamicProgramming.Stock;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
    // maximum transaction
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return totalProfit(dp, prices, 0, 1);
    }

    int totalProfit(int[][] dp, int[] prices, int index, int buy) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        if (buy == 1) {
            return dp[index][buy] = Math.max(-prices[index] + totalProfit(dp, prices, index + 1, buy ^ 1), totalProfit(dp, prices, index + 1, buy));
        } else {
            return dp[index][buy] = Math.max(prices[index] + totalProfit(dp, prices, index + 1, buy ^ 1), totalProfit(dp, prices, index + 1, buy));
        }
    }

    public int maxProfitSum(int[] prices) {
        int length = prices.length;
        int minPrice = prices[0];
        int profit = 0;

        for (int num : prices) {
            if (num < minPrice) {
                minPrice = num;
            } else if (num > minPrice) {
                profit += num - minPrice;
                minPrice = num;
            }
        }
        return profit;
    }
}

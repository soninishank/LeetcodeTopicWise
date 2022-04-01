package BuyAndSellStock;

import java.util.Arrays;

/**
 * @author akhilkalari
 * @project Leetcode on 3/30/22
 */
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class InfiniteTransactions_2 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return calcMaxProfitInfiniteTransaction(prices, 0, 1, dp);
    }

    private int calcMaxProfitInfiniteTransaction(int[] prices, int index, int buy, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        if (buy == 1) {
            return dp[index][buy] = Math.max(-prices[index] + calcMaxProfitInfiniteTransaction(prices, index + 1, buy ^ 1, dp), calcMaxProfitInfiniteTransaction(prices, index + 1, buy, dp));
        } else {
            return dp[index][buy] = Math.max(prices[index] + calcMaxProfitInfiniteTransaction(prices, index + 1, buy ^ 1, dp), calcMaxProfitInfiniteTransaction(prices, index + 1, buy, dp));
        }
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = new InfiniteTransactions_2().maxProfit(prices);
        System.out.println(i);
    }
}

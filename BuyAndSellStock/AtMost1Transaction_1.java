package BuyAndSellStock;

import java.util.Arrays;

/**
 * @author NISHANK SONI
 * @project Leetcode on 3/29/22
 */
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class AtMost1Transaction_1 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return calcMaxProfit1Transaction(prices, 0, 1, 1, dp);
    }

    private int calcMaxProfit1Transaction(int[] prices, int index, int buy, int allowedTransaction, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }
        if (0 >= allowedTransaction) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        if (buy == 1) {
            return dp[index][buy] = Math.max(-prices[index] + calcMaxProfit1Transaction(prices, index + 1, buy ^ 1, allowedTransaction, dp), calcMaxProfit1Transaction(prices, index + 1, buy, allowedTransaction, dp));
        } else {
            return dp[index][buy] = Math.max(prices[index] + calcMaxProfit1Transaction(prices, index + 1, buy ^ 1, allowedTransaction - 1, dp), calcMaxProfit1Transaction(prices, index + 1, buy, allowedTransaction, dp));
        }
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = new AtMost1Transaction_1().maxProfit(prices);
        System.out.println(i);
    }
}

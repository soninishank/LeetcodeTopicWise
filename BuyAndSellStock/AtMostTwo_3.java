package BuyAndSellStock;

import java.util.Arrays;

/**
 * @author akhilkalari
 * @project Leetcode on 3/29/22
 */
public class AtMostTwo_3 {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][2];
        for (int[][] ints : dp) {
            for (int[] internal : ints) {
                Arrays.fill(internal, -1);
            }
        }
        return getProfitTwoTransactions(prices, 0, 1, 0, dp, 2);
    }

    int getProfitTwoTransactions(int[] prices, int index, int buy, int transactionCount, int[][][] dp, int allowedTransactions) {
        if (index > prices.length - 1) {
            return 0;
        }
        if (transactionCount >= allowedTransactions) {
            return 0;
        }
        if (dp[index][buy][transactionCount] != -1) {
            return dp[index][buy][transactionCount];
        }
        if (buy == 1) {
            return dp[index][buy][transactionCount] = Math.max(-prices[index] + getProfitTwoTransactions(prices, index + 1, buy ^ 1, transactionCount, dp, 2), getProfitTwoTransactions(prices, index + 1, buy, transactionCount, dp, allowedTransactions));
        }
        // transaction will get completed when we sell the stock completely
        else {
            return dp[index][buy][transactionCount] = Math.max(prices[index] + getProfitTwoTransactions(prices, index + 1, buy ^ 1, transactionCount + 1, dp, 2), getProfitTwoTransactions(prices, index + 1, buy, transactionCount, dp, allowedTransactions));
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 3, 5, 0, 0, 3, 1, 4};
        int i = new AtMostTwo_3().maxProfit(arr);
        System.out.println(i);
    }
}

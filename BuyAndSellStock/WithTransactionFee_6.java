package BuyAndSellStock;

import java.util.Arrays;

/**
 * @author akhilkalari
 * @project Leetcode on 3/30/22
 */
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class WithTransactionFee_6 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return calcMaxProfitWithTransactionFee(prices, 0, 1, dp, fee);
    }

    private int calcMaxProfitWithTransactionFee(int[] prices, int index, int buy, int[][] dp, int fee) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        if (buy == 1) {
            return dp[index][buy] = Math.max(-prices[index] + calcMaxProfitWithTransactionFee(prices, index + 1, buy ^ 1, dp, fee), calcMaxProfitWithTransactionFee(prices, index + 1, buy, dp, fee));
        } else {
            return dp[index][buy] = Math.max(prices[index] - fee + calcMaxProfitWithTransactionFee(prices, index + 1, buy ^ 1, dp, fee), calcMaxProfitWithTransactionFee(prices, index + 1, buy, dp, fee));
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int i = new WithTransactionFee_6().maxProfit(arr, fee);
        System.out.println(i);
    }
}

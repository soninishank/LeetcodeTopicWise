package Coding.BuyAndSellStock;

import java.util.Arrays;

/**
 * @author nishank soni
 * @project Leetcode on 3/29/22
 */
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices, int index, int buy, int[][] dp) {
        if (index > prices.length - 1) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        if (buy == 1) {
            return dp[index][buy] = Math.max(-prices[index] + maxProfit(prices, index + 1, buy ^ 1, dp), maxProfit(prices, index + 1, buy, dp));
        } else {
            return dp[index][buy] = Math.max(prices[index] + maxProfit(prices, index + 1, buy ^ 1, dp), maxProfit(prices, index + 1, buy, dp));
        }
    }

    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (prices[i] - minValue > maxProfit) {
                maxProfit = prices[i] - minValue;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        int[][] dp = new int[arr.length][2];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int i = new BestTimeToBuySellStock().maxProfit(arr, 0, 1, dp);
        System.out.println(i);
    }
}

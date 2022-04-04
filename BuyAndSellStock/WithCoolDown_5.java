package BuyAndSellStock;

import java.util.Arrays;

/**
 * @author akhilkalari
 * @project Leetcode on 3/30/22
 */
public class WithCoolDown_5 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return calcMaxProfitWithCoolDown(prices, 0, 1, dp);
    }

    private int calcMaxProfitWithCoolDown(int[] prices, int index, int buy, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        if (buy == 1) {
            return dp[index][buy] = Math.max(-prices[index] + calcMaxProfitWithCoolDown(prices, index + 1, buy ^ 1, dp), calcMaxProfitWithCoolDown(prices, index + 1, buy, dp));
        } else {
            return dp[index][buy] = Math.max(prices[index] + calcMaxProfitWithCoolDown(prices, index + 2, buy ^ 1, dp), calcMaxProfitWithCoolDown(prices, index + 1, buy, dp));
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 0, 2};
        int i = new WithCoolDown_5().maxProfit(arr);
        System.out.println(i);
    }
}

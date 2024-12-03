package Coding.DynamicProgramming.Stock;

public class BestTimeToBuyAndSellStock {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    public int maxProfit(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int diff = prices[i] - minPrice;
                if (diff > maxProfit) {
                    maxProfit = diff;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = new BestTimeToBuyAndSellStockII().maxProfit(prices);
        System.out.println(i);
    }
}

package Coding.DynamicProgramming.LCSPatterns;

import java.util.Arrays;

public class LongestIncreasingSubsequenceWithoutLCS {

    int dp[];

    private int lengthOfLIS(int[] arr) {
        dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = 1 + dp[j];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        int i = new LongestIncreasingSubsequenceWithoutLCS().lengthOfLIS(arr);
        System.out.println(i);
    }

}

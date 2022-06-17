package Coding.DynamicProgramming.LCSPatterns;

import java.util.TreeSet;

// https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
        }
        int[] uniqueArray = new int[treeSet.size()];
        int i = 0;
        for (Integer value : treeSet) {
            uniqueArray[i++] = value;
        }
        return lcs(nums, uniqueArray, nums.length, uniqueArray.length);
    }

    private int lcs(int[] X, int[] Y, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        int i = new LongestIncreasingSubsequence().lengthOfLIS(arr);
        System.out.println(i);
    }
}

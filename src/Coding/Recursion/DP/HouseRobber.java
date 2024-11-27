package Coding.Recursion.DP;

// https://leetcode.com/problems/house-robber/
// 198. House Robber
public class HouseRobber {
    // Using Recursion
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return solveRecursion(nums, 0);
    }

    private int solveRecursion(int[] nums, int index) {
        if (index < 0 || index > nums.length - 1) {
            return 0;
        }
        int steal_current = nums[index] + solveRecursion(nums, index + 2);
        int steal_next = solveRecursion(nums, index + 1);
        return Math.max(steal_current, steal_next);
    }

    Integer[] dp;

    public int robUsingDp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        dp = new Integer[nums.length + 1];
        return solveRecursionUsingDp(nums, 0);
    }

    private int solveRecursionUsingDp(int[] nums, int index) {
        if (index < 0 || index > nums.length - 1) {
            return 0;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        int steal_current = nums[index] + solveRecursion(nums, index + 2);
        int steal_next = solveRecursion(nums, index + 1);
        dp[index] = Math.max(steal_current, steal_next);
        return dp[index];
    }
}

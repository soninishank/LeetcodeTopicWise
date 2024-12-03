package Coding.Recursion.DP;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber-ii/
// 213. House Robber II
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1)
            return nums[0]; // If there's only one house, return its value.
        return Math.max(solveRecursion(nums, 0, length - 2), solveRecursion(nums, 1, length - 1));
    }

    private int solveRecursion(int[] nums, int start, int end) {
        if (start > end) {
            return 0; // No houses to rob.
        }
        int steal_current = nums[start] + solveRecursion(nums, start + 2, end);
        int steal_next = solveRecursion(nums, start + 1, end);
        return Math.max(steal_current, steal_next);
    }


    public int robUsingDp(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0]; // If there's only one house, return its value.

        // Solve for both scenarios and take the maximum
        return Math.max(robHelperDp(nums, 0, n - 2), robHelperDp(nums, 1, n - 1));
    }

    private int robHelperDp(int[] nums, int start, int end) {
        int[] memo = new int[nums.length]; // Create a memoization array.
        Arrays.fill(memo, -1); // Fill it with -1 to indicate calculated values.
        return robHelperRecursive(nums, start, end, memo);
    }

    private int robHelperRecursive(int[] nums, int start, int end, int[] memo) {
        if (start > end) {
            return 0; // No houses to rob.
        }

        if (memo[start] != -1) {
            return memo[start]; // If already calculated, return the cached result.
        }

        // Recursion: rob the current house or skip it.
        int robCurrent = nums[start] + robHelperRecursive(nums, start + 2, end, memo);
        int skipCurrent = robHelperRecursive(nums, start + 1, end, memo);

        // Store the result in a memo array.
        memo[start] = Math.max(robCurrent, skipCurrent);
        return memo[start];
    }
}

package Coding.DynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/partition-equal-subset-sum/
// sum must be even - otherwise it's not possible to divide
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) {
            return false;
        }
        return applyRecursion(nums, totalSum / 2, nums.length - 1);
    }

    boolean applyRecursion(int[] nums, int totalSum, int index) {
        if (totalSum == 0) {
            return true;
        }
        if (totalSum < 0 || index < 0) {
            return false;
        }
        return applyRecursion(nums, totalSum - nums[index], index - 1) || applyRecursion(nums, totalSum, index - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean b = new PartitionEqualSubsetSum().canPartition(nums);
        System.out.println(b);
    }
}

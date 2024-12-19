package Coding.Array;

// https://leetcode.com/problems/maximum-subarray/
// 53. Maximum Subarray
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int currentValue = 0;
        for (int i = 0; i < nums.length; i++) {
            currentValue += nums[i];
            if (max_so_far < currentValue) {
                max_so_far = currentValue;
            }
            if (currentValue < 0){
                currentValue = 0;
            }
        }
        return max_so_far;
    }
}

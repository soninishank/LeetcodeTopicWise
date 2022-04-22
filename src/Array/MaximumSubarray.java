package Array;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int currentValue = 0;
        for (int i = 0; i < nums.length; i++) {
            currentValue += nums[i];
            if (max_so_far < currentValue) {
                max_so_far = currentValue;
            }
            currentValue = Math.max(0, currentValue);
        }
        return max_so_far;
    }
}

package Coding.Array;

// https://leetcode.com/problems/maximum-product-subarray/
// when the result = 0 make it 1
// always note max value because let's say you have only single digit {-3} then max = -3
public class MaximumProductSubarray {
    int max = Integer.MIN_VALUE;

    private int maxProduct(int[] nums) {
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            result *= nums[i];
            max = Math.max(max, result);

            if (result == 0) {
                result = 1;
            }
        }
        result = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            result *= nums[j];
            max = Math.max(max, result);

            if (result == 0) {
                result = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -1, -1};
        int i = new MaximumProductSubarray().maxProduct(nums);
        System.out.println(i);
    }
}

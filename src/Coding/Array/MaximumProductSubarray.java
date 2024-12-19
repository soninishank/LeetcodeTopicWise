package Coding.Array;

// https://leetcode.com/problems/maximum-product-subarray/
// when the result = 0 make it 1
// always note max value because let's say you have only single digit {-3} then max = -3
public class MaximumProductSubarray {

    private int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE; // Initialize max to the smallest possible value
        int result = 1;

        // Forward pass
        for (int i = 0; i < nums.length; i++) {
            result *= nums[i];
            max = Math.max(max, result);
            if (result == 0) {
                result = 1; // Reset the product if zero is encountered
            }
        }

        result = 1; // Reset for the backward pass

        // Backward pass
        for (int j = nums.length - 1; j >= 0; j--) {
            result *= nums[j];
            max = Math.max(max, result);
            if (result == 0) {
                result = 1; // Reset the product if zero is encountered
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

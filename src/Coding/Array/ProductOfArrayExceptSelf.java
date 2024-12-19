package Coding.Array;

// https://leetcode.com/problems/product-of-array-except-self/
// 238. Product of Array Except Self
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] leftSide = new int[nums.length];
        int[] rightSide = new int[nums.length];

        leftSide[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftSide[i] = leftSide[i - 1] * nums[i - 1];
        }

        rightSide[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSide[i] = nums[i + 1] * rightSide[i + 1];
            rightSide[i + 1] = rightSide[i + 1] * leftSide[i + 1];
        }
        return rightSide;
    }

    // only one array is used
    public int[] productExceptSelfUsingOneArray(int[] nums) {
        int[] result = new int[nums.length];
        // Calculate the left product and store it in the result array
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        // Calculate the right product on the fly and multiply it with the left product
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;  // Multiply the left product with the current right product
            rightProduct *= nums[i];   // Update the right product
        }
        return result;
    }
}

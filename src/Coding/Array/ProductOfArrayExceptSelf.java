package Coding.Array;

// https://leetcode.com/problems/product-of-array-except-self/
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
}

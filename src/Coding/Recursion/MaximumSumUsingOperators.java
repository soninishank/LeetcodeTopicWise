package Coding.Recursion;

public class MaximumSumUsingOperators {
    public int findTargetSumWays(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int sum) {
        if (nums.length == index) {
            return 1;
        }
        if (index > nums.length) {
            return 0;
        }
        int multiply = helper(nums, index + 1, sum * nums[index]);
        int addition = helper(nums, index + 1, sum + nums[index]);
        return Math.max(multiply, addition);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 5};
        int targetSumWays = new MaximumSumUsingOperators().findTargetSumWays(arr);
        System.out.println(targetSumWays);
    }
}

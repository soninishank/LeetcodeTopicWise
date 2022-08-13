package Coding.Recursion;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        return helper(nums, target, 0, 0);
    }

    private int helper(int[] nums, int target, int index, int sum) {
        if (nums.length == index) {
            if (target == sum) {
                return 1;
            } else {
                return 0;
            }
        }
        if (index > nums.length) {
            return 0;
        }
        int positive = helper(nums, target, index + 1, sum + nums[index]);
        int negative = helper(nums, target, index + 1, sum - nums[index]);
        return negative + positive;
    }

    //  -> 22 -> sum = 5 , index = 5 -> return 0 - positive
    //  -> 23 -> sum = 5 , index = 5 -> return 0 - negative


    public static void main(String[] args) {
        int targetSumWays = new TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}

// 1, 1, 1, 1, 1 -

// 1 + 1 + 1 + 1 - 1
// 1 + 1 + 1 - 1 + 1
// 1 + 1 - 1 + 1 + 1
// 1 - 1 + 1 + 1 + 1
// -1 + 1 + 1 + 1+1
package Coding.Design;

// https://leetcode.com/problems/range-sum-query-immutable/
public class RangeSumQuery {

    // Build cumulative sum
    int[] cumulativeSum;

    public RangeSumQuery(int[] nums) {
        cumulativeSum = new int[nums.length];
        cumulativeSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cumulativeSum[i] = nums[i] + cumulativeSum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return cumulativeSum[right];
        }
        int value = cumulativeSum[right] - cumulativeSum[left - 1];
        return value;
    }

    public static void main(String[] args) {
        RangeSumQuery numArray = new RangeSumQuery(new int[]{-2, 0, 3, -5, 2, -1});
        numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
        numArray.sumRange(2, 3); // return 3 + (-5)  = -2
        numArray.sumRange(0, 5);
    }
}

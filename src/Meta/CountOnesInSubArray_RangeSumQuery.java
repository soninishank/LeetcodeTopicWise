package Meta;

// https://leetcode.com/problems/range-sum-query-immutable/
public class CountOnesInSubArray_RangeSumQuery {
    int[] nums;

    public CountOnesInSubArray_RangeSumQuery(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];

        this.nums = nums;
    }

    public int sumRange(int start, int end) {
        if (start == 0) {
            return nums[end];
        }
        return nums[end] - nums[start - 1];
    }
}

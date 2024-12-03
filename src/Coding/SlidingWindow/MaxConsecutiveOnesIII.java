package Coding.SlidingWindow;

// https://leetcode.com/problems/max-consecutive-ones-iii/
// Basic sliding window template
// 1004. Max Consecutive Ones III
public class MaxConsecutiveOnesIII {
    private int maxLength = Integer.MIN_VALUE;

    public int longestOnes(int[] nums, int k) {
        int end = 0, start = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                k--;
            }
            end++;
            while (k < 0) {
                if (nums[start] == 0) {
                    k++;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }

}

package SlidingWindow;

// https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int end = 0, start = 0;
        int count = 0;
        int result = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[start] == 0) {
                    count--;
                }
                start++;
            }
            end++;
            result = Math.max(result, end - start);
        }
        return result;
    }
}

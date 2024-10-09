package Coding.HashMap;

import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/
// 128. Longest Consecutive Sequence - TC is O(n) and SC is O(n)
public class LongestConsecutiveSequence {

    // only go in one direction
    public int longestConsecutive(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> hashset = new HashSet<>();
        for (int arr : nums) {
            hashset.add(arr);
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            // Find the starting location from where to count - // Only check for the start of a sequence
            if (!hashset.contains(nums[i] - 1)) {
                while (hashset.contains(nums[i] + count)) {
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}

package Coding.HashMap;

import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {

    // only go in one direction
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> hashset = new HashSet<Integer>();
        for (int val : nums) {
            hashset.add(val);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (hashset.contains(nums[i] - 1)) {
                continue;
            } else {
                int value = 1;
                while (hashset.contains(nums[i] + value)) {
                    value++;
                }
                max = Math.max(value, max);
            }
        }
        return max;
    }
}

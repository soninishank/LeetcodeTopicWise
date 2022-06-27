package Coding.DynamicProgramming;

// https://leetcode.com/problems/increasing-triplet-subsequence/
public class IncreasingTripletSequence {
    public boolean increasingTriplet(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = Math.min(left[i - 1], nums[i]);
        }
        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (left[i] < nums[i] && nums[i] < right[i]) {
                return true;
            }
        }
        return false;
    }
}

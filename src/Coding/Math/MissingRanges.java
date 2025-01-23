package Coding.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/missing-ranges/
// 163. Missing Ranges

public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> missingRanges = new ArrayList<>();
        if (n == 0) {
            missingRanges.add(Arrays.asList(lower, upper));
            return missingRanges;
        }

        // TODO : Remember that we are not increasing i loop in lower and upper

        // Check for any missing numbers between the lower bound and nums[0].
        if (lower < nums[0]) {
            missingRanges.add(Arrays.asList(lower, nums[0] - 1));
        }
        // Check for any missing numbers between successive elements of nums.
        for (int i = 0; i < n - 1; i++) {
            int currentElement = nums[i];
            int nextElement = nums[i + 1];
            int diff = nums[i + 1] - nums[i];
            if (diff <= 1) {
                continue;
            }
            missingRanges.add(Arrays.asList(currentElement + 1, nextElement - 1));
        }
        // Check for any missing numbers between the last element of nums and the upper bound.
        if (upper > nums[n - 1]) {
            missingRanges.add(Arrays.asList(nums[n - 1] + 1, upper));
        }
        return missingRanges;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 7, 13, 20};
        List<List<Integer>> missingRanges = new MissingRanges().findMissingRanges(nums, 0, 99);
        System.out.println(missingRanges);
    }
}

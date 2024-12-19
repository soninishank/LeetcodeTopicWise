package Coding.TwoPointers.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
// 15. 3Sum
public class ThreeSum {

    // -4, -1, -1, 0, 1, 2
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        if (nums.length < 3) {
            return finalList;
        }
        Arrays.sort(nums); // O(NlogN)
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for the current `i`
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    finalList.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // Skip duplicate elements for `low` and `high`
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return finalList;
    }
}

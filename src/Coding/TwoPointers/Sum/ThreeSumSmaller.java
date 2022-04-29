package Coding.TwoPointers.Sum;

import java.util.Arrays;

/**
 * @author Nishank Soni
 * @project LeetcodeTopicWise on 4/1/22
 * https://leetcode.com/problems/3sum-smaller/
 */

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[low] + nums[high] + nums[i];
                if (sum < target) {
                    count += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }
        return count;
    }
}

// start + low + high = target
// low + high = target - start
// -21, -3, -2, 2, 4,  5  -> target = 2
// 1st num -> nums[0] -> -21 , target = 2 - (-21) = 23
// -3 + 5 < 23 , -3 + 4 < 23 , -3 + 2 < 23 , -3 -2 < 23
// That's why sum is high-low"

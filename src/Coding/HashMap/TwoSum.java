package Coding.HashMap;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/
// Time complexity - O(n)
// The containsKey and put operations for HashMap have an average time complexity of 𝑂(1).
// Space complexity - O(n)
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = new TwoSum().twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}

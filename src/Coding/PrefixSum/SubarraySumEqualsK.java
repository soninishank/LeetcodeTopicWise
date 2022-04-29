package Coding.PrefixSum;

import java.util.HashMap;

// running sum
// https://leetcode.com/problems/subarray-sum-equals-k/
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int runningSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (runningSum == k) {
                count++;
            }
            if (hashMap.containsKey(runningSum - k)) {
                count += hashMap.get(runningSum - k);
            }
            hashMap.put(runningSum, hashMap.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        int i = new SubarraySumEqualsK().subarraySum(nums, k);
        System.out.println(i);
    }
}

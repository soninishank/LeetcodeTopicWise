package Coding.PrefixSum;

import java.util.HashMap;

// running sum - subarray with given sum
// https://leetcode.com/problems/subarray-sum-equals-k/
// hashmap contains key as running sum & its value is count
// 1. if the running sum == k , count++
// 2. if hashmap contains runningSum-k, count++
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store the cumulative sum and its frequency
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        // Initialize with 0 sum having frequency of 1
        prefixSumCount.put(0, 1); // it is very crucial - take below example

        int runningSum = 0; // To store the cumulative sum
        int count = 0;   // To count the number of subarrays with sum equals k

        // Iterate through the array
        for (int num : nums) {
            runningSum += num;

            // If currSum - k exists in prefixSumCount, add the count to result
            if (prefixSumCount.containsKey(runningSum - k)) {
                count += prefixSumCount.get(runningSum - k);
            }

            // Update the frequency of the current cumulative sum in the map
            prefixSumCount.put(runningSum, prefixSumCount.getOrDefault(runningSum, 0) + 1);
        }

        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        int i = new SubarraySumEqualsK().subarraySum(nums, k);
        System.out.println(i);

        // sum = {{1,2},{3}}
        // {1,2} -> sum = 3 , 3-3 = 0 if we don;t add line 15, we will miss this
    }
}

package Coding.PrefixSum;

import java.util.HashMap;

// https://leetcode.com/problems/continuous-subarray-sum/
public class ContinuousSubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int runningSum = 0;
        hashMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum = runningSum % k;
            }
            if (hashMap.containsKey(runningSum)) {
                if (i - hashMap.get(runningSum) > 1) {
                    return true;
                }
            } else {
                hashMap.put(runningSum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5, 0, 0, 0};
        int k = 3;
        boolean b = new ContinuousSubArraySum().checkSubarraySum(nums, k);
        System.out.println(b);
    }
}

package Coding.PrefixSum;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/continuous-subarray-sum/
public class ContinuousSubArraySum {

    // https://www.youtube.com/watch?v=wmn3c1mP0pY
    public boolean checkSubarraySum(int[] nums, int k) {
        // Base case
        if (k == 0) {
            return false;
        }
        Map<Integer, Integer> hashmap = new HashMap<>(); // <remainder,index>
        // The idea behind hashmap.put(0, -1); is to handle the scenario where the cumulative sum from the start of the array (index 0) up to the current index is directly divisible by k. In this case, the remainder will be 0.
        hashmap.put(0, -1);
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int remainder = currentSum % k;
            if (hashmap.containsKey(remainder)) {
                int getIndex = hashmap.get(remainder);
                int diff = i - getIndex;
                if (diff >= 2) {
                    return true;
                }
            } else {
                hashmap.put(remainder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5, 0, 0, 0};
        int k = 3; // The sum of the subarray [0,0] is :- 0 + 0 = 0
        // And 0 % 3 = 0, so it is divisible by k = 3
        boolean b = new ContinuousSubArraySum().checkSubarraySum(nums, k);
        System.out.println(b);
    }
}

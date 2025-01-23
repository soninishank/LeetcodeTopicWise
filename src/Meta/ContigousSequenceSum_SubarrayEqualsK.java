package Meta;

import java.util.HashMap;

// https://leetcode.com/discuss/interview-question/algorithms/124820/facebook-subarray-sum-equals-k
public class ContigousSequenceSum_SubarrayEqualsK {
    // Bruteforce solution
    public boolean hasSequence(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int current_sum = 0;
            for (int j = i; j < n; j++) {
                current_sum += nums[j];
                if (current_sum == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // TC - O(N)
    // SC - O(N)
    public boolean hasSequenceUsingPrefixSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        // when runningSum = 3 , k = 3
        // 3 - 3 = 0
        hashmap.put(0, 1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            // 6-3 = 3 -> hashmap.get -> 1
            if (hashmap.containsKey(runningSum - target)) {
                return true;
            }
            hashmap.put(runningSum, hashmap.getOrDefault(runningSum, 0) + 1);
        }
        return false;
    }
}

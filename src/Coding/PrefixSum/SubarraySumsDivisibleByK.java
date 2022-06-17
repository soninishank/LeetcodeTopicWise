package Coding.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            int remainder = sum % k;
            if (remainder < 0) {
                remainder = remainder + k;
            }
            count += map.getOrDefault(remainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        System.out.println(map);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int i = new SubarraySumsDivisibleByK().subarraysDivByK(nums, k);
        System.out.println(i);
    }
}

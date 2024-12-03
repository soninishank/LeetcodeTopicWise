package Coding.PrefixSum;

import java.util.*;

// https://leetcode.com/problems/random-pick-index/
// 398. Random Pick Index
public class RandomPickWithIndex {
    private Map<Integer, List<Integer>> numIndices;

    public RandomPickWithIndex(int[] nums) {
        numIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = numIndices.get(target);
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}


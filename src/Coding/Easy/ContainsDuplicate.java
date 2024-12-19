package Coding.Easy;

import java.util.Arrays;
import java.util.HashSet;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {

    // Time complexity - O(N)
    // Space complexity - O(N)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        for (int value : nums) {
            if (hashset.contains(value)) {
                return true;
            }
            hashset.add(value);
        }
        return false;
    }

    // To optimize space, we need to sort it first
    // TC - O(N) SC - O(1)
    public boolean containsDuplicateUsingSort(int[] nums) {
        Arrays.sort(nums); // O(n log n)
        for (int i = 1; i < nums.length; i++) { // O(n)
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        boolean i = new ContainsDuplicate().containsDuplicate(nums);
        System.out.println(i);
    }
}

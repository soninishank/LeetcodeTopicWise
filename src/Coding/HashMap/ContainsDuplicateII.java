package Coding.HashMap;

import java.util.HashSet;

// https://leetcode.com/problems/contains-duplicate-ii/
// 219. Contains Duplicate II
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashset = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashset.contains(nums[i])) {
                return true;
            }
            hashset.add(nums[i]);
            // Also make sure that you are putting this condition at the end
            if (hashset.size() > k) {
                hashset.remove(nums[i - k]); // You need to make sure that you are using nums[i-k] because in hashset you can't remove by index.
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean b = new ContainsDuplicateII().containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }
}

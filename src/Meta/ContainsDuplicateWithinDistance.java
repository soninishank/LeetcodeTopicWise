package Meta;

import java.util.HashSet;

// https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicateWithinDistance {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashset = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashset.contains(nums[i])) {
                return true;
            }
            hashset.add(nums[i]);
            if (hashset.size() > k) {
                int num = nums[i - k];
                hashset.remove(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 2, 3};
        int k = 3;
        boolean b = new ContainsDuplicateWithinDistance().containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }
}

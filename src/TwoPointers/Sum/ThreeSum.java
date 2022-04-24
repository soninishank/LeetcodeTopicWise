package TwoPointers.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nishank Soni
 * @project LeetcodeTopicWise on 4/1/22
 */
// https://leetcode.com/problems/3sum/
public class ThreeSum {
    List<List<Integer>> finalList = new ArrayList<>();

    // -4, -1, -1, 0, 1, 2
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return finalList;
        }
        Arrays.sort(nums); // O(NlogN)
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                List<Integer> list = new ArrayList<>();
                if (nums[i] + nums[low] + nums[high] == 0) {
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    finalList.add(list);
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (nums[low] + nums[high] + nums[i] > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return finalList;
    }
}

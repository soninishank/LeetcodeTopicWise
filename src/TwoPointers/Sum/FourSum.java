package TwoPointers.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nishank Soni
 * @project LeetcodeTopicWise on 4/1/22
 */
public class FourSum {
     List<List<Integer>> finalList = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0) {
            return finalList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    List<Integer> list = new ArrayList<>();
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        list.add(nums[i]);
                        list.add(nums[j]);
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
                    } else if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return finalList;
    }
}

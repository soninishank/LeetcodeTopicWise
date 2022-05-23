package Coding.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    List<List<Integer>> permuteList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return permuteList;
        }
        Arrays.sort(nums);// sorting is needed for duplicate
        boolean[] number = new boolean[nums.length];
        applyPermutationBacktracking(nums, new ArrayList<>(), number);
        return permuteList;
    }

    private void applyPermutationBacktracking(int[] nums, ArrayList<Integer> arrayList, boolean[] number) {
        if (arrayList.size() == nums.length) {
            permuteList.add(new ArrayList<>(arrayList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((number[i]) || (i > 0 && nums[i] == nums[i - 1] && !number[i - 1])) {
                continue;
            }
            number[i] = true;
            arrayList.add(nums[i]);
            applyPermutationBacktracking(nums, arrayList, number);
            number[i] = false;
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> list = new PermutationsII().permuteUnique(nums);
        System.out.println(list);
    }
}

package Coding.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/
public class SubsetsII {

    List<List<Integer>> subsetListII = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return subsetListII;
        }
        Arrays.sort(nums);
        applyBacktrackingSubsets(nums, 0, new ArrayList<>());
        return subsetListII;
    }

    private void applyBacktrackingSubsets(int[] arr, int index, ArrayList<Integer> list) {
        subsetListII.add(new ArrayList<>(list));
        if (index > arr.length - 1) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (index > 0 && arr[index] == arr[index - 1]) {
                continue;
            }
            list.add(arr[i]);
            applyBacktrackingSubsets(arr, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> list = new SubsetsII().subsetsWithDup(nums);
        System.out.println(list);
    }
}

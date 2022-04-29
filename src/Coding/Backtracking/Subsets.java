package Coding.Backtracking;

import java.util.ArrayList;
import java.util.List;

// i + 1 -> because we need to include the next set of integers
// https://leetcode.com/problems/subsets/
public class Subsets {

    List<List<Integer>> subsetList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return subsetList;
        }
        applyBacktrackingSubsets(nums, 0, new ArrayList<>());
        return subsetList;
    }

    private void applyBacktrackingSubsets(int[] arr, int index, ArrayList<Integer> list) {
        subsetList.add(new ArrayList<>(list));
        if (index > arr.length - 1) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            applyBacktrackingSubsets(arr, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new Subsets().subsets(nums);
        System.out.println(subsets);
    }
}

package Coding.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class Permutation {

    List<List<Integer>> permuteList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return permuteList;
        }
        applyPermutationBacktracking(nums, new ArrayList<Integer>());
        return permuteList;
    }

    private void applyPermutationBacktracking(int[] nums, ArrayList<Integer> arrayList) {
        if (arrayList.size() == nums.length) {
            permuteList.add(new ArrayList<>(arrayList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (arrayList.contains(nums[i])) continue;
            arrayList.add(nums[i]);
            applyPermutationBacktracking(nums, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        List<List<Integer>> permute = new Permutation().permute(arr);
        System.out.println(permute);
    }
}

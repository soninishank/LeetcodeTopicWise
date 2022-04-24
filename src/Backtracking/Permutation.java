package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    List<List<Integer>> permuteList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return permuteList;
        }
        applyPermutationBacktracking(nums, 0, new ArrayList<Integer>());
        return permuteList;
    }

    private void applyPermutationBacktracking(int[] nums, int index, ArrayList<Integer> arrayList) {
        if (arrayList.size() == nums.length) {
            permuteList.add(new ArrayList<>(arrayList));
            return;
        }
        if (index > nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            arrayList.add(nums[i]);
            applyPermutationBacktracking(nums, index + 1, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        List<List<Integer>> permute = new Permutation().permute(arr);
        System.out.println(permute);
    }
}

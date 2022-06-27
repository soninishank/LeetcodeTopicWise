package Coding.Backtracking;

import java.util.*;

public class PermutationsII {
    List<List<Integer>> permuteList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return permuteList;
        }
        Arrays.sort(nums);// sorting is needed for duplicate
        boolean[] visited = new boolean[nums.length];
        Set<List<Integer>> set = new HashSet<>();
        applyPermutationBacktracking(nums, set, visited, new ArrayList<>());
        for (List<Integer> list : set) {
            permuteList.add(list);
        }
        return permuteList;
    }

    private void applyPermutationBacktracking(int[] nums, Set<List<Integer>> result, boolean[] visited, List<Integer> sublist) {
        if (sublist.size() == nums.length) {
            result.add(new ArrayList<>(sublist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                sublist.add(nums[i]);
                visited[i] = true;
                applyPermutationBacktracking(nums, result, visited, sublist);
                visited[i] = false;
                sublist.remove(sublist.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> list = new PermutationsII().permuteUnique(nums);
        System.out.println(list);
    }
}

package Coding.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Each number in candidates may only be used once in the combination.
public class CombinationSumII {
    List<List<Integer>> combinationSumList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return combinationSumList;
        }
        Arrays.sort(candidates);
        applyBacktrackingCombinationSum(candidates, target, 0, new ArrayList<Integer>());
        return combinationSumList;
    }

    private void applyBacktrackingCombinationSum(int[] candidates, int target, int index, ArrayList<Integer> arrayList) {
        if (target == 0) {
            combinationSumList.add(new ArrayList<>(arrayList));
            return;
        }
        if (index > candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            arrayList.add(candidates[i]);
            applyBacktrackingCombinationSum(candidates, target - candidates[i], i + 1, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> list = new CombinationSumII().combinationSum2(candidates, target);
        System.out.println(list);
    }
}

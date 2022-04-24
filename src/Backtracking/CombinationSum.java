package Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
// same number can be used multiple times -
public class CombinationSum {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return resultList;
        }
        applyBacktrackingCombination(candidates, target, 0, new ArrayList<>(), 0);
        return resultList;
    }

    private void applyBacktrackingCombination(int[] candidates, int target, int index, ArrayList<Integer> list, int currentSum) {
        if (target == currentSum) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        if (currentSum > target) {
            return;
        }
        if (index > candidates.length - 1) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            currentSum += candidates[i];
            applyBacktrackingCombination(candidates, target, i, list, currentSum);
            currentSum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }


    // we are passing i in the backtrack function not the index
    // i pass - [[2, 2, 3], [7]]
    // index pass - [[2, 2, 3], [2, 3, 2], [3, 2, 2], [7]] -> it will explore back the old options also

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> list = new CombinationSum().combinationSum(candidates, target);
        System.out.println(list);
    }
}

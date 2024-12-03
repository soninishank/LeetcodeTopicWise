package Coding.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/
// 77. Combinations
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, result, 1, new ArrayList<>(), k);
        return result;
    }

    private void backtrack(int totalLength, List<List<Integer>> resultList, int index, List<Integer> list, int k) {
        if (list.size() == k) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= totalLength; i++) {
            list.add(i);
            backtrack(totalLength, resultList, i + 1, list, k);
            list.remove(list.size() - 1);
        }
    }
}

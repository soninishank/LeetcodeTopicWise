package Coding.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPossibleCombinations {

    List<List<Integer>> resultList = new ArrayList<>();

    List<List<Integer>> printCombination(int[] arr, int k) {
        finalCombination(arr, k, 0, new ArrayList<>());
        return resultList;
    }

    private void finalCombination(int[] arr, int k, int i, ArrayList<Integer> list) {
        if (list.size() == k) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        for (int m = i; m < arr.length; m++) {
            list.add(arr[m]);
            finalCombination(arr, k, m + 1, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        List<List<Integer>> list = new PrintAllPossibleCombinations().printCombination(arr, 2);
        System.out.println(list);
    }
}

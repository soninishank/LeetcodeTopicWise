package Coding.Recursion;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
public class SubsetSumPrint {
    List<List<Integer>> resultList = new ArrayList<>();

    private List<List<Integer>> isSubsetSum(int arr[], int n, int target) {
        if (arr.length == 0) {
            return resultList;
        }
        applyRecursion(arr, n - 1, target, new ArrayList<Integer>());
        return resultList;
    }

    private void applyRecursion(int[] arr, int index, int target, ArrayList<Integer> list) {
        if (target == 0) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || index < 0) {
            return;
        }
        if (arr[index] > target) {
            applyRecursion(arr, index - 1, target, list);
        } else {
            // take
            list.add(arr[index]);
            applyRecursion(arr, index - 1, target - arr[index], list);
            list.remove(list.size() - 1);
            // not take
            applyRecursion(arr, index - 1, target, list);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int target = 10;
        List<List<Integer>> subsetSum = new SubsetSumPrint().isSubsetSum(arr, arr.length, target);
        System.out.println(subsetSum);
    }
}

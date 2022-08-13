package Coding.Recursion;

// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
public class SubsetSumExists {

    boolean isSubsetSum(int arr[], int n, int target) {
        if (arr.length == 0) {
            return false;
        }
        return applyRecursion(arr, n - 1, target);
    }

    private boolean applyRecursion(int[] arr, int n, int target) {
        if (n < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        // take
        boolean a = applyRecursion(arr, n - 1, target - arr[n]);
        // not take
        boolean b = applyRecursion(arr, n - 1, target);
        return a || b;
    }

    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 6, 2};
        int target = 9;
        boolean subsetSum = new SubsetSumExists().isSubsetSum(arr, arr.length, target);
        System.out.println(subsetSum);
    }
}

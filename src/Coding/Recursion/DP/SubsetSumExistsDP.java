package Coding.Recursion.DP;

// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
public class SubsetSumExistsDP {
    boolean isSubsetSum(int arr[], int n, int target) {
        if (arr.length == 0) {
            return false;
        }
        Boolean[][] dp = new Boolean[n + 1][target + 1];
        return applyRecursion(arr, n - 1, target, dp);
    }

    private boolean applyRecursion(int[] arr, int n, int target, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }
        if (n < 0) {
            return false;
        }
        if (target < 0) {
            return false;
        }
        if (dp[n][target] != null) {
            return dp[n][target];
        }
        // skip the element
        if (arr[n] > target) {
            return applyRecursion(arr, n - 1, target, dp);
        } else {
            // take
            boolean a = applyRecursion(arr, n - 1, target - arr[n], dp);
            // not take
            boolean b = applyRecursion(arr, n - 1, target, dp);
            return dp[n][target] = a || b;
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 34, 6, 12, 6, 2};
        int target = 9;
        boolean subsetSum = new SubsetSumExistsDP().isSubsetSum(arr, arr.length, target);
        System.out.println(subsetSum);
    }
}

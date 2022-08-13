package Coding.Recursion;

public class CountSubsetSumEqualToTarget {

    private int isSubsetSum(int arr[], int n, int target) {
        if (arr.length == 0) {
            return 0;
        }
        return applyRecursion(arr, n - 1, target);
    }

    private int applyRecursion(int[] arr, int index, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || index < 0) {
            return 0;
        }
        if (arr[index] > target) {
            return applyRecursion(arr, index - 1, target);
        } else {
            // take

            int take = applyRecursion(arr, index - 1, target - arr[index]);
            // not take
            int notTake = applyRecursion(arr, index - 1, target);
            return take + notTake;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int target = 10;
        int subsetSum = new CountSubsetSumEqualToTarget().isSubsetSum(arr, arr.length, target);
        System.out.println(subsetSum);
    }
}

package Coding.Recursion;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class CoinChange {
    public long count(int arr[], int m, int sum) {
        // code here.
        if (arr.length == 0) {
            return 0;
        }
        return applyRecursion(arr, sum);
    }

    private int applyRecursion(int[] arr, int sum) {
        if (sum == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= sum) {
                result += applyRecursion(arr, sum - arr[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 3, 6};
        long count = new CoinChange().count(arr, arr.length, 10);
        System.out.println(count);
    }
}

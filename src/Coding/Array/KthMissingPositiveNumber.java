package Coding.Array;

// https://leetcode.com/problems/kth-missing-positive-number/
// 1539. Kth Missing Positive Number
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int missing = 1;
        int j = 0;

        while (j < arr.length) {
            if (arr[j] == missing) {
                j++;
            } else {
                k--;
            }
            if (k == 0) {
                return missing;
            }
            missing++;
        }
        while (k > 0) {
            missing++;
            k--;
        }
        return missing - 1;
    }
}

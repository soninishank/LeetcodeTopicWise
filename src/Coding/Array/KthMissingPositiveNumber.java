package Coding.Array;

// https://leetcode.com/problems/kth-missing-positive-number/
// 1539. Kth Missing Positive Number
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int currentNo = 1;
        int currentIndex = 0;
        while (currentIndex < arr.length) {
            if (arr[currentIndex] == currentNo) {
                currentIndex++;
            } else {
                k--;
            }
            if (k == 0) {
                return currentNo;
            }
            currentNo++;
        }
        while (k > 0) {
            currentNo++;
            k--;
        }
        return currentNo - 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int kthPositive = new KthMissingPositiveNumber().findKthPositive(arr, k);
        System.out.println(kthPositive);
    }
}

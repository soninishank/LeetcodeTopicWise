package Coding.CyclicSort;

import java.util.Arrays;

// https://leetcode.com/problems/missing-number/
// containing n distinct numbers in the range [0, n]
public class MissingNumber {
    void sortCycleFrom0toN(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int j = arr[i]; // index where value needs to swapped
            if (j < arr.length && arr[i] != arr[j]) { // 4 != 0
                swap(arr, i, j);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    private void findMissingNumber(int[] nums) {
        sortCycleFrom0toN(nums);
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                break;
            }
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        int arr0[] = {4, 0, 3, 1};
        new MissingNumber().findMissingNumber(arr0);
    }

}

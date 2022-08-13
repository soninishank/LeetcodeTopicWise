package Coding.CyclicSort;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-duplicate-number/
// [1, n] inclusive
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        sortCycleFrom1toN(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return nums.length + 1;
    }

    private void sortCycleFrom1toN(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int j = arr[i] - 1; // index where value needs to swapped    1,2,3 - 3 is at 2nd index
            // 0,1,2,3 - 3 is at 3rd index only
            if (arr[i] != arr[j]) { // 4 != 0
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


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2};
        int duplicate = new FindDuplicateNumber().findDuplicate(arr);
        System.out.println(duplicate);
    }
}

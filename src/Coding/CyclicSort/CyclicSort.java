package Coding.CyclicSort;

import java.util.Arrays;

// https://www.geeksforgeeks.org/sort-an-array-which-contain-1-to-n-values-in-on-using-cycle-sort/
public class CyclicSort {

    // 4,3,1,2,0
    void sortCycleFrom0toN(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int j = arr[i]; // index where value needs to swapped
            if (arr[i] != arr[j]) { // 4 != 0
                swap(arr, i, j);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 4,3,1,5,2
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


    private void sortCycleFrom2toN(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int j = arr[i] - 2; // index where value needs to swapped    2,3 - 3 is at 1st index  - that's why we are subtracting 2
            // 0,1,2,3 - 3 is at 3rd index only
            if (arr[i] != arr[j]) { // 4 != 0
                swap(arr, i, j);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 1, 2, 0};
        new CyclicSort().sortCycleFrom0toN(arr);
        int arr1[] = {3, 1, 5, 4, 0, 2};

        int arr0[] = {3, 1, 5, 4, 2};
        int arr00[] = {2, 6, 4, 3, 1, 5};
        new CyclicSort().sortCycleFrom1toN(arr0);
        new CyclicSort().sortCycleFrom1toN(arr00);

        int arr2[] = {5, 6, 2, 3, 4};
        new CyclicSort().sortCycleFrom2toN(arr2);
    }

    void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}

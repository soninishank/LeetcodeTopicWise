package Coding.CyclicSort;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// the range [1, n]
public class FindAllNumbersDisappearedInArray {

    private void sortCycleFrom1toN(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int j = arr[i] - 1; // index where value needs to swapped    1,2,3 - 3 is at 2nd position
            // 0,1,2,3 - 3 is at 3rd index only
            if (arr[i] != arr[j]) { // 4 != 0
                swap(arr, i, j);
            } else {
                i++;
            }
        }
    }

    void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        sortCycleFrom1toN(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                list.add(i + 1);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = new FindAllNumbersDisappearedInArray().findDisappearedNumbers(arr);
        System.out.println(disappearedNumbers);
    }
}

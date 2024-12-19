package Coding.CyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  range [1, n]
// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        sortCycleFrom1toN(nums);
        System.out.println(Arrays.toString(nums));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

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


    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    // It will not throw indexOutOfBoundException because number starts from 1 <= nums[i] <= n
    public List<Integer> findDuplicatesUsingIndex(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1; // original index
            if (nums[index] < 0)
            {
                res.add(Math.abs(index+1));
            }
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 6, 3, 1};
        List<Integer> duplicates = new FindAllDuplicatesInAnArray().findDuplicates(arr);
        System.out.println(duplicates);
    }
}

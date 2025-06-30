package Coding.Array;

import java.util.Arrays;

// https://leetcode.com/problems/next-permutation/
// https://leetcode.com/problems/next-greater-element-iii/
// 1. Find the first decreasing element - start from end
// 2. Find the next larger element - start from end - compare the above 1st result index
// 3. Swap the pivot and the next larger element
// 4. Reverse the suffix - after the above 1st result index
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // Step 1: Find the first decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // Step 2: If found, find the next larger element
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: Swap the pivot element with the next larger element
            swap(nums, i, j);
        }
        // Step 4: Reverse the elements after the pivot
        reverse(nums, i + 1, n - 1);
    }

    // Helper method to swap two elements in an array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method to reverse a portion of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7, 5, 0};
        new NextPermutation().nextPermutation(arr);
        System.out.println("The next permutations " + Arrays.toString(arr));
    }
}
